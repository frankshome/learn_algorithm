package l4_selection_sort_detect_performance;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

public class SortTestHelper {
    public static Integer[] generateRandomArray(int length, int rangeL, int rangeR) {
        Preconditions.checkArgument(rangeL <= rangeR, "rangL <= rangR");
        Integer[] data = new Integer[length];
        for (int i = 0; i < length; i++) {
            data[i] = (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }

        return data;
    }

    private static <T extends Comparable> boolean isSorted(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0){
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
        System.out.println("排序元素:" + data.length + "个,共用时(ms):" + (endTime - beginTime));
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.join(generateRandomArray(5, 1, 10), ','));
    }
}
