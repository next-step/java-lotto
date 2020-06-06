package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
    @Test
    void 숫자를_생성한다_범위는_1에서_45까지() {
        Numbers numbers = new Numbers();
        List<Integer> numberList = numbers.getNumbers();

        int min = Collections.min(numberList);
        int max = Collections.max(numberList);

        int minExpected = 1, maxAndSizeExpected = 45;

        assertThat(numberList).size().isEqualTo(maxAndSizeExpected);
        assertThat(min).isEqualTo(minExpected);
        assertThat(max).isEqualTo(maxAndSizeExpected);
    }

}