package calculator;

import calculator.service.ValidationCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationCheckTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 빈 값이 들어오면 오류를 내보낸다.")
    void null_공백(String input) {
        assertThatThrownBy(() -> {
            ValidationCheck.checkInputString(input);
        })
                .isInstanceOf(NullPointerException.class)
                .hasMessage(null);
    }

    @Test
    @DisplayName("입력된 문자열이 짝수 갯수로 들어왔을때 오류를 내보내는지 확인한다.")
    void 입력문자열_길이체크_오류() {
        String input = "2 + 3 * 4 -";
        assertThatThrownBy(() -> {
            ValidationCheck.checkInputString(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산이 제대로 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("입력된 문자열의 홀수번째에 숫자가 들어오지 않았다면 오류를 내보내는지 확인한다.")
    void 입력문자열_홀수번째숫자_오류() {
        String input = "- + 3 * 4";
        assertThatThrownBy(() -> {
            ValidationCheck.checkInputString(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("홀수번째에는 숫자가 와야합니다.");
    }

    @ParameterizedTest
    @DisplayName("입력된 문자열의 짝수번째에 사칙연산자가 아닌 다른 기호가 들어오면 오류를 내보내는지 확인한다.")
    @CsvSource(value = {"2 3 3 * 4", "2 & 3 * 4"})
    void 입력문자열_짝수번째_사칙연산자입력_오류() {
        String input = "2 & 3 * 4";
        assertThatThrownBy(() -> {
            ValidationCheck.checkInputString(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("짝수번째에는 사칙연산자가 와야합니다.");
    }
}
