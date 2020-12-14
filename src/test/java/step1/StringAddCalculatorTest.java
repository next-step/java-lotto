package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("Numbers 객체를 입력받아 덧셈을 수행한다.")
    void calculate() {
        Integer[] numberArray = {1, 2, 3};
        Numbers numbers = new Numbers(numberArray);

        assertThat(StringAddCalculator.calculate(numbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("Numbers 객체가 비어있을 경우 답은 0을 반환한다.")
    void calculate_zero() {
        Integer[] numberArray = {};
        Numbers numbers = new Numbers(numberArray);

        assertThat(StringAddCalculator.calculate(numbers)).isEqualTo(0);
    }
}
