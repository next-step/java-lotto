package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("입력된 번호가 List에 포함되면 true를 반환해야 한다.")
    void containsNumberTrueTest() {

        // given
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));
        Number number = new Number(1);

        // when
        boolean result = numbers.contains(number);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("입력된 번호가 List에 포함되지 않으면 false를 반환해야 한다.")
    void containsNumberFalseTest() {

        // given
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));
        Number number = new Number(7);

        // when
        boolean result = numbers.contains(number);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("다른 Numbers와 동일한 number의 갯수를 반환할 수 있다.")
    void calculateMatchedNumberCountTest() {

        // given
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));

        Numbers compareNumbers =new Numbers(Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));

        // when
        int result = numbers.calculateMatchedNumberCount(compareNumbers);

        // then
        assertThat(result).isEqualTo(3);
    }

}
