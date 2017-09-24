package l6_insert_sort_advance;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class SortTest {

    @Test
    public void testSort() throws Exception {
        int N = 1000;
        Integer[] data = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] cloneData = ArrayUtils.clone(data);
        System.out.println("优化前:");
        SortTestHelper.testSort(l5_insert_sort.InsertSort.class, cloneData);
        System.out.println("优化后:");
        SortTestHelper.testSort(InsertSort.class, data);
    }
}
