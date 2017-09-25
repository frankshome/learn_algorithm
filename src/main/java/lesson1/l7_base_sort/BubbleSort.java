package lesson1.l7_base_sort;

import org.apache.commons.lang3.ArrayUtils;

public class BubbleSort {
    private BubbleSort(){}

    public static <T extends Comparable> void sort(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i].compareTo(data[j]) > 0) {
                    ArrayUtils.swap(data, i, j);
                }
            }
        }
    }
}
