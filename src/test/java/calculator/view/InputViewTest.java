package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 1. null이거나 빈 공백 문자열일 경우 IllegalArgumentException 예외가 발생한다.
 * 2. 사칙연산 기호가 (+, -, /, *) 아닌 경우 IllegalArgumentException 예외가 발생한다.
 */
public class InputViewTest {

    @DisplayName("빈 공백 입력 시 IllegalArgumentExceptiond얘외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void create_nullOrEmptyStringCheck(String input) {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null 또는 빈 공백 문자를 전달할 수 없습니다.");
    }

    @DisplayName("사칙연산 기호가 (+, -, /, *) 아닌 기호를 포함할 경우 IllegalArgumentException 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2 C 3 - 4 / 2", "2 ^ 3 * 4"})
    void create_improperOperator(String input) {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 사칙연산이 아닙니다.");
    }
}
