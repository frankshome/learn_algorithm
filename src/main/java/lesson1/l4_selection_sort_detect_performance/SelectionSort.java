package lesson1.l4_selection_sort_detect_performance;

public class SelectionSort {
    private SelectionSort(){}

    public static <T extends Comparable> void sort(T[] data){
        for (int i = 0; i < data.length; i++) {
            int minDataIdx = i;
            for (int j = i + 1; j < data.length; j++){
                if (data[j].compareTo(data[minDataIdx]) < 0) {
                    minDataIdx = j;
                }
            }
            swap(data, i, minDataIdx);
        }
    }

    private static <T extends Comparable> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        Integer[] data = SortTestHelper.generateRandomArray(100000, 1, 100);
        SortTestHelper.testSort(SelectionSort.class, data);
    }
}
