package lotto.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;
    
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }
    
    @Test
    @DisplayName("덧셈")
    void add() {
        int result = stringCalculator.calculate("2 + 5");
        assertThat(result).isEqualTo(7);
    }
    
    @Test
    @DisplayName("뺄셈")
    void subtract() {
        int result = stringCalculator.calculate("2 - 5");
        assertThat(result).isEqualTo(-3);
    }
    
    @Test
    @DisplayName("곱셈")
    void multiply() {
        int result = stringCalculator.calculate("2 * 5");
        assertThat(result).isEqualTo(10);
    }
    
    @Test
    @DisplayName("나눗셈")
    void divide() {
        int result = stringCalculator.calculate("10 / 5");
        assertThat(result).isEqualTo(2);
    }
    
    @Test
    @DisplayName("나눗셈 예외")
    void divide_exception() {
        assertThatThrownBy(() -> stringCalculator.calculate("9 / 5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("나눗셈은 정확히 나누어 떨어지는 경우에만 진행할 수 있습니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("여러 숫자 사칙연산")
    void numbers_calculate() {
        int result = stringCalculator.calculate("2 + 3 * 4 / 2 + 100 - 50 / 5 - 2 * 10");
        assertThat(result).isEqualTo(100);
    }
    
    @DisplayName("숫자와 기호 사이에 공백이 없는 경우 예외")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"2 + 3 * 4 /2", "2 + 3 *4 / 2", "2 + 3 * 4/ 2", "2 + 3 *4/ 2"})
    void not_space_exception(String formula) {
        assertThatThrownBy(() -> stringCalculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 계산 식이 아닙니다. 다시 입력해 주세요.");
    }
    
    @DisplayName("사칙연산 기호가 아닌 경우 예외")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"2 & 3 * 4 / 2", "2 + 3 % 4 / 2", "2 # 3 * 4 / 2", "2 + 3 * 4 ++ 2"})
    void symbol_exception(String formula) {
        assertThatThrownBy(() -> stringCalculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 계산 식이 아닙니다. 다시 입력해 주세요.");
    }
    
    @DisplayName("null 및 \"\" 입력 시 예외")
    @ParameterizedTest(name = "{displayName} : {0}")
    @NullAndEmptySource
    void null_and_empty_exception(String formula) {
        assertThatThrownBy(() -> stringCalculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 계산 식이 아닙니다. 다시 입력해 주세요.");
    }
    
    @DisplayName("숫자나 기호를 연속으로 같은 것을 입력 시 예외")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"2 + - 3 * 4 / 2", "2 + 5 3 * 4 / 2", "2 10 + 3 * 4 / 2", "2 + 3 * / 4 / 2"})
    void different_order_exception(String formula) {
        assertThatThrownBy(() -> stringCalculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 계산 식이 아닙니다. 다시 입력해 주세요.");
    }
}
