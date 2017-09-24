package l5_insert_sort;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class InsertSort {

    private InsertSort(){}

    public static <T extends Comparable> void sort(T[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j].compareTo(data[j-1]) > 0){
                    break;
                }else{
                    swap(data, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int len = 10000;
        Integer[] data = SortTestHelper.generateRandomArray(len, 0, len);
        Integer[] cloneData = ArrayUtils.clone(data);
        System.out.println(StringUtils.join(data, ','));
        SortTestHelper.testSort(InsertSort.class, data);
        SortTestHelper.testSort(SelectionSort.class, cloneData);
        System.out.println(StringUtils.join(data, ','));

    }
}
