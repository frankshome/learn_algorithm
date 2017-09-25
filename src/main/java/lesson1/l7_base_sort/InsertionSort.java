package lesson1.l7_base_sort;

import org.apache.commons.lang3.ArrayUtils;

public class InsertionSort {
    private InsertionSort(){}

    public static <T extends Comparable> void sort(T[] data){
        for (int i = 0; i < data.length; i++) {
            T t = data[i];
            int j = i;
            for (; j > 0 && data[j - 1].compareTo(t) > 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = t;
        }
    }
}
