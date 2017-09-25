package lesson1.l7_base_sort;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;

public class SortTestHelper {
    private SortTestHelper(){}

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        Preconditions.checkArgument(rangeL <= rangeR);
        Integer[] data = new Integer[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return data;
    }

    private static <T extends Comparable> boolean isSorted(T[] data){
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i + 1].compareTo(data[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable> void test(Class sortClass, T[] data) throws Exception {
        Method method = sortClass.getMethod("sort", new Class[]{Comparable[].class});
        long beginTime = System.currentTimeMillis();
        method.invoke(null, new Object[]{data});
        long endTime = System.currentTimeMillis();
        Preconditions.checkState(isSorted(data));
        System.out.println(String.format("%s,排序%d个元素,用时:%d ms", sortClass.getSimpleName(), data.length, endTime - beginTime));

    }
}
