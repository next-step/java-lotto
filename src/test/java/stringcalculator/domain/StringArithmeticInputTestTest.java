package stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import stringcalculator.domain.Number;
import stringcalculator.domain.StringArithmeticInput;

public class StringArithmeticInputTestTest {


    @DisplayName("공백을 체크하여 분리한다")
    @Test
    void input_split() {
        String input = "1 + 2 + 3";

        String[] splitted = input.split(" ");

        Assertions.assertThat(splitted).contains("1", "+", "2", "+", "3");
    }

    @DisplayName("유효하지 않은 값에 대해서는 예외를 발생시킨다")
    @ParameterizedTest
    @NullAndEmptySource
    void input_invalid(String input) {
        Assertions.assertThatThrownBy(() -> {
                      new StringArithmeticInput(input);
                  })
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 + 2 + 3,6", "2 * 3 * 4,24", "1 + 11 / 4,3", "1 - 2 * 6 / 3,-2" })
    void 계산한다(String input, int expected) {
        Assertions.assertThat(new StringArithmeticInput(input).evaluate())
                  .isEqualTo(Number.of(expected));
    }
}
