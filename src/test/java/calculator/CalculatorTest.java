package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
