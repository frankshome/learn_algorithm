package l3_selection_sort_gen_testcase;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class SortTestHelper {
    private SortTestHelper(){}

    public static Integer[] generateRandomArray(int length, int rangeL, int rangeR){
        Preconditions.checkArgument(rangeL <= rangeR, "rangeL <= rangR");
        Integer[] data = new Integer[length];
        for (int i = 0; i < length; i++) {
            data[i] = Integer.valueOf((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return data;
    }


    public static void main(String[] args) {
        System.out.println(StringUtils.join(generateRandomArray(5, 1, 100), ','));
    }
}
