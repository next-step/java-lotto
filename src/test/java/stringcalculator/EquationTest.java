package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringcalculator.ExceptionMessage.WHITESPACE_REQUIRED_BETWEEN_CHARACTER;

class EquationTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void inputIsNullOrBlankGiven_throwException(String input) {
        assertThatThrownBy(() -> new Equation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_SHOULD_NOT_NULL_OR_BLANK.getMessage());
    }

    @DisplayName("문자 사이에 공백이 없을 경우 Exception")
    @ParameterizedTest
    @ValueSource(strings = {"1+2", "1 +2", "-1 + 2"})
    void NoWhitespaceBetweenElementsGiven_throwException(String input) {
        assertThatThrownBy(() -> new Equation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WHITESPACE_REQUIRED_BETWEEN_CHARACTER.getMessage());
    }

    @Test
    void splitDelimiterGiven_ReturnSplitResult() {
        String delimiter = " ";
        assertThat(new Equation("1 + 2").split(delimiter)).isEqualTo(List.of("1", "+", "2"));
        assertThat(new Equation("12 + 22").split(delimiter)).isEqualTo(List.of("12", "+", "22"));
    }
}
