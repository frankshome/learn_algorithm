package lesson1.l5_insertion_sort;

import org.apache.commons.lang3.ArrayUtils;

public class SelectionSort {
    private SelectionSort(){}
    public static <T extends Comparable> void sort(T[] data) {
        for (int i = 0; i < data.length; i++) {
            int minDataIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minDataIdx]) < 0) {
                    minDataIdx = j;
                }
            }
            ArrayUtils.swap(data, i, minDataIdx);
        }
    }
}
