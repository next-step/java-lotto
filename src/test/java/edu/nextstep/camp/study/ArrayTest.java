package edu.nextstep.camp.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayTest {

    @Test
    void Array_Equals_TEST() {
        List<Integer> integers = List.of(1, 2, 3, 4);
        List<Integer> integers2 = new ArrayList<>();
        List<Integer> integers3 = new LinkedList<>();

        integers2.addAll(integers);
        integers3.addAll(integers);

        assertThat(integers).isEqualTo(integers2);
        assertThat(integers).isEqualTo(integers3);
    }

    @Test
    void Array_sublist_테스트() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> subList = integers.subList(0, 6);

        assertThat(subList).contains(1, 2, 3, 4, 5, 6);
        assertThat(subList).size().isEqualTo(6);
        assertThat(integers).size().isEqualTo(8);
    }
}
