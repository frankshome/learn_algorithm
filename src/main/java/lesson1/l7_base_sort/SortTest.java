package lesson1.l7_base_sort;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SortTest {

    @Test
    public void testSelectionSort() throws Exception {
        int N = 1000;
        Integer[] data = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] cloneData1 = ArrayUtils.clone(data);
        Integer[] cloneData2 = ArrayUtils.clone(data);
        SortTestHelper.test(SelectionSort.class, data);
        SortTestHelper.test(InsertionSort.class, cloneData1);
        SortTestHelper.test(BubbleSort.class, cloneData2);
    }
}
