package lotto.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    @Test
    void sort() {
        List<Integer> list = Arrays.asList(4, 2, 3, 1);
        list.sort(Integer::compareTo);
        System.out.println("list = " + list);
    }
}
