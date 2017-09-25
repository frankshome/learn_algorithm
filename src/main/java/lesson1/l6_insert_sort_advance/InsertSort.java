package lesson1.l6_insert_sort_advance;

import org.apache.commons.lang3.StringUtils;

public class InsertSort {
    private InsertSort(){}

    public static <T extends Comparable> void sort(T[] data) {
        for (int i = 0; i < data.length; i++) {
            T t = data[i];
            int j = i;
            for (;j > 0 && data[j - 1].compareTo(t) > 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = t;
        }
    }

    public static void main(String[] args) {
        Integer[] data = SortTestHelper.generateRandomArray(10, 0, 10);
        System.out.println(StringUtils.join(data, ','));
        sort(data);
        System.out.println(StringUtils.join(data, ','));

    }
}
