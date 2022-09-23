package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("나눗셈은 정확히 나누어 떨어지는 경우에만 진행할 수 있습니다. 다시 입력해주세요.");
    }
}
