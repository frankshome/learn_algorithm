package lesson1.l2_selection_sort;

import lesson1.l3_selection_sort_gen_testcase.SortTestHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by xuhu on 2017/9/23.
 */
public class SelectionSort {

    private SelectionSort(){}

    public static <T extends Comparable> void sort(T[] data){
        for(int i = 0; i < data.length; i++){
            int minDataIdx = i;
            for (int j = i + 1; j < data.length; j++) {
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

    public static void main(String[] args) {
        Integer[] data1 = SortTestHelper.generateRandomArray(10, 1, 30);
        System.out.println("pre sort:" + StringUtils.join(data1, ','));
        sort(data1);
        System.out.println("sorted:" + StringUtils.join(data1, ','));

        System.out.println("=====================================");

        Float[] data2 = {10.06f, 22.8f, 66.6f, 9.68f, 7.12f, 12.99f, 5f, 1f, 66.7f};
        sort(data2);
        System.out.println(StringUtils.join(data2, ','));

        System.out.println("=====================================");
        Student stu1 = Student.StudentBuilder.aStudent()
                .withId(10001).withName("xuhu").withScore(95).build();

        Student stu2 = Student.StudentBuilder.aStudent()
                .withId(10002).withName("xuhu").withScore(85).build();

        Student stu3 = Student.StudentBuilder.aStudent()
                .withId(10003).withName("xuhu").withScore(86).build();

        Student stu5 = Student.StudentBuilder.aStudent()
                .withId(10005).withName("xuhu").withScore(86).build();

        Student[] data3 = {stu1, stu2, stu3, stu5};
        SelectionSort.sort(data3);
        System.out.println(StringUtils.join(data3, ','));

    }
}
