package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {


    @Test
    @DisplayName("구분자로 구분된 모든 숫자를 더한다.")
    void add_all_operands() {
        Calculator calculator = new Calculator();
        int result = calculator.operate(Arrays.asList(1, 2, 3), new AddingStrategy());
        assertThat(result).isEqualTo(6);

    }


    @Test
    @DisplayName("구분자로 구분된 모든 숫자를 음수로 바꾼뒤 더한다.")
    void subtract_all_operands() {
        Calculator calculator = new Calculator();
        int result = calculator.operate(Arrays.asList(1, 2, 3), new SubtractingStrategy());
        assertThat(result).isEqualTo(-6);

    }
}