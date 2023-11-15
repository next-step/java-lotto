package lotto;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberShufflerTest {

    @Test
    void getShuffledNumbers_숫자_6개_섞기() {
        int[] numbers = NumberShuffler.getShuffledNumbers();
        assertEquals(6, numbers.length);
    }

    @RepeatedTest(1000)
    void getShuffledNumbers_최대값_45() {
        List<Integer> numberList = Arrays.stream(NumberShuffler.getShuffledNumbers()).boxed().sorted().collect(Collectors.toList());

        assertThat(numberList.get(numberList.size() - 1)).isNotNegative().isLessThanOrEqualTo(45);
    }

    @RepeatedTest(1000)
    void getShuffledNumbers_최소값_1() {
        List<Integer> numberList = Arrays.stream(NumberShuffler.getShuffledNumbers()).boxed().sorted().collect(Collectors.toList());

        assertThat(numberList.get(0)).isNotNegative().isGreaterThanOrEqualTo(1);
    }
}