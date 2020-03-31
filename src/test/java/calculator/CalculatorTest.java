package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("문자열 덧셈 계산기는 ','를 구분자로 하여 각 문자열을 분리할 수 있다")
    @Test
    void split() {
        Calculator calculator = new Calculator();
        String[] tokens = calculator.split("1,2,3");

        Assertions.assertThat(tokens).containsExactly("1", "2", "3");
    }
}
