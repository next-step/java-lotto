package lotto.domain;

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

}
