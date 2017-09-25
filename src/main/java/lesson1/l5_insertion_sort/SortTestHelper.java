package lesson1.l5_insertion_sort;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;

public class SortTestHelper {

    private SortTestHelper(){}

    public static Integer[] generateRandomArray(int length, int rangeL, int rangeR) {
        Preconditions.checkArgument(rangeL <= rangeR, "rangeL <= rangR");
        Integer[] data = new Integer[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return data;
    }

    public static <T extends Comparable> boolean isSorted(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable> void testSort(Class sortClass, T[] data) throws Exception {
        Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
        long beginTime = System.currentTimeMillis();
        sortMethod.invoke(null, new Object[]{   data});
        long endTime = System.currentTimeMillis();
        Preconditions.checkState(isSorted(data));
        System.out.println(sortClass.getSimpleName()+"排序元素:" + data.length + "用时(ms):" + (endTime - beginTime));

    }

}
