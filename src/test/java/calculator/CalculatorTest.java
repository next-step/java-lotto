package calculator;

import static calculator.Calculator.*;
import static calculator.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CalculatorTest {
    @DisplayName("공백으로 문자열에서 숫자와 사칙연산 분리")
    @Test
    void 문자열_분리() {
        String input = "4 + 6";
        String calculateArray[] = splitInput(input);
        assertThat(calculateArray[0]).isEqualTo("4");
        assertThat(calculateArray[1]).isEqualTo("+");
        assertThat(calculateArray[2]).isEqualTo("6");
    }

    @DisplayName("입력받은 문자가 빈 공백이거나 null일 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 빈공백문자_혹은_null일경우_에러(String input) {
        assertThatThrownBy(() -> {
            splitInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLINK_INPUT_ERROR);
    }

}