package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionTest {

    @ParameterizedTest
    @DisplayName("빈 입력값에 대해 exception 발생")
    @ValueSource(strings = {"", "      "})
    public void 빈_입력값_exception(String argument) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Expression.validate(argument);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 기호가 있는 경우 exception 발생 - 괄호 비허용")
    @ValueSource(strings = {"( 1 + 2 ) - 3", " 1 % 3 + 1"})
    public void 사칙연산_기호_확인(String argument) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Expression.validate(argument);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 연속해서 있는 경우 exception 발생")
    @ValueSource(strings = {"1 +  + 3 + 1", "3 * * 1 + 2"})
    public void 사칙연산_연속_확인(String argument) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Expression.validate(argument);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호로 시작하거나 끝나는 경우 exception 발생")
    @ValueSource(strings = {"+ 1 + 3 + 1 -", "1 + 2 - 3 - "})
    public void 가장자리_연산자_확인(String argument) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Expression.validate(argument);
        });
    }

    @ParameterizedTest
    @DisplayName("숫자로만 이루어진 문자열인지 확인")
    @CsvSource({"123, true", "1+2, false"})
    public void 숫자인지_확인(String input, boolean expected) {
        Assertions.assertThat(Expression.isNumber(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("유효한 연산자인지 확인")
    @CsvSource({"+, true", "%, false"})
    public void 연산자인지_확인(String input, boolean expected) {
        Assertions.assertThat(Expression.isOperator(input))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("공백을 기준으로 token 분리")
    public void 공백_기준_토큰_분리() {
        Assertions.assertThat(Expression.splitByTokens("1  + 2     - 3  * 4  ").size())
                .isEqualTo(7);
        Assertions.assertThat(Expression.splitByTokens("  1 + 2 - 3 * 4  ").get(1))
                .isEqualTo("+");
    }

    @Test
    @DisplayName("공백으로 나뉘지 않은 표현식에서 exception 발생")
    public void 나뉘지_않은_식() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Expression.validate(" 1+2 -   3 * 4");
        });
    }
}
