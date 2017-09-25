package lesson1.l6_insertion_sort_advance;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

public class SortTestHelper {
    private SortTestHelper(){}

    public static <T extends Comparable> Integer[] generateRandomArray(int length, int rangeL, int rangeR) {
        Preconditions.checkArgument(rangeL <= rangeR);
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
        Method method = sortClass.getMethod("sort", new Class[]{Comparable[].class});
        long beginTime = System.currentTimeMillis();
        method.invoke(null, new Object[]{data});
        long endTime = System.currentTimeMillis();
        Preconditions.checkState(isSorted(data));
        System.out.println(String.format("%s,排序元素:%d个,共用时:%d ms",
                sortClass.getSimpleName(), data.length, endTime - beginTime));

    }

    public static void main(String[] args) {
        System.out.println(StringUtils.join(generateRandomArray(10, 0, 10), ','));
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int posX = (int) (Math.random() * n);
            int posY = (int) (Math.random() * n);
            int t = data[posX];
            data[posX] = data[posY];
            data[posY] = t;
        }
        return data;
    }
}
