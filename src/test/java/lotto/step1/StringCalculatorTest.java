package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈")
    void add() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 + 5");
        assertThat(result).isEqualTo(7);
    }
    
    @Test
    @DisplayName("뺄셈")
    void subtract() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 - 5");
        assertThat(result).isEqualTo(-3);
    }
    
    @Test
    @DisplayName("곱셈")
    void multiply() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 * 5");
        assertThat(result).isEqualTo(10);
    }
    
    @Test
    @DisplayName("나눗셈")
    void divide() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("10 / 5");
        assertThat(result).isEqualTo(2);
    }
    
    @Test
    @DisplayName("나눗셈 예외")
    void divide_exception() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(() -> stringCalculator.calculate("9 / 5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("나눗셈은 정확히 나누어 떨어지는 경우에만 진행할 수 있습니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("여러 숫자 사칙연산")
    void numbers_calculate() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 + 3 * 4 / 2 + 100 - 50 / 5 - 2 * 10");
        assertThat(result).isEqualTo(100);
    }
    
    @DisplayName("숫자와 기호 사이에 공백이 없는 경우 예외")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"2 + 3 * 4 /2", "2 + 3 *4 / 2", "2 + 3 * 4/ 2", "2 + 3 *4/ 2"})
    void not_space_exception(String formula) {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(() -> stringCalculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 계산 식이 아닙니다. 다시 입력해 주세요.");
    }
    
    @DisplayName("사칙연산 기호가 아닌 경우 예외")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"2 & 3 * 4 / 2", "2 + 3 % 4 / 2", "2 # 3 * 4 / 2", "2 + 3 * 4 ++ 2"})
    void symbol_exception(String formula) {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(() -> stringCalculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 계산 식이 아닙니다. 다시 입력해 주세요.");
    }
}
