package lesson1.l1_selection_sort;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by xuhu on 2017/9/23.
 */
public class SellectionSort {

    private SellectionSort(){}

    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minDataIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minDataIdx]) {
                    minDataIdx = j;
                }
            }
            swap(data, i, minDataIdx);
        }
    }

    private static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 33, 22, 66, 19};
        sort(data);
        System.out.println(StringUtils.join(data, ','));
    }
}
