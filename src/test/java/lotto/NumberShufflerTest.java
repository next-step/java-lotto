package lotto;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberShufflerTest {

    @Test
    void getShuffledNumbers_숫자_6개_섞기() {
        List<Integer> numbers = NumberShuffler.getShuffledNumbers();
        assertEquals(6, numbers.size());
    }

    @RepeatedTest(1000)
    void getShuffledNumbers_최대값_45() {
        List<Integer> numbers = NumberShuffler.getShuffledNumbers();

        assertThat(numbers.get(numbers.size() - 1)).isNotNegative().isLessThanOrEqualTo(45);
    }

    @RepeatedTest(1000)
    void getShuffledNumbers_최소값_1() {
        List<Integer> numbers = NumberShuffler.getShuffledNumbers();

        assertThat(numbers.get(0)).isNotNegative().isGreaterThanOrEqualTo(1);
    }
}