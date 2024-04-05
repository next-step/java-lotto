package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 랜덤번호_6개_생성() {
        int startInclusive = 1;
        int endInclusive = 45;
        Numbers numbers = Numbers.uniqueRandomOf(startInclusive, endInclusive);
        int expected = 6;

        assertThat(numbers.createRandomNumbers(6).size()).isEqualTo(expected);
    }
}