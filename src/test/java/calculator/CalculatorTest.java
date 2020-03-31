package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("문자열 덧셈 계산기는 ','를 구분자로 하여 각 문자열을 분리할 수 있다")
    @Test
    void split() {
        Calculator calculator = new Calculator();
        String[] tokens = calculator.split("1,2,3");

        assertThat(tokens).containsExactly("1", "2", "3");
    }

    @DisplayName("문자열 덧셈 계산기는 ','를 구분자로 하여 각 문자열을 분리한 후 합을 구할 수 있다")
    @Test
    void sumEachTokens() {
        Calculator calculator = new Calculator();
        double sum = calculator.sum("1,2,3,4,5");

        assertThat(sum).isEqualTo(15);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다")
    @Test
    void throwRuntimeExceptionsIfNonNumberOrNegativeNumber() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> {
            calculator.sum("1,2,a,b,3");
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            calculator.sum("1,2,5,-10,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
