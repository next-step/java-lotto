package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {


    @Test
    @DisplayName("구분자로 구분된 모든 숫자를 더한다.")
    void add_all_operands() {

        OperationInputs testAddingInputs = new OperationInputs("1,2,3", new AddingStrategy());
        StringCalculator calculator = new StringCalculator();
        int result = calculator.operate(testAddingInputs);
        assertThat(result).isEqualTo(6);

    }


    @Test
    @DisplayName("구분자로 구분된 모든 숫자를 음수로 바꾼뒤 더한다.")
    void subtract_all_operands() {
        OperationInputs testSubtractingInputs = new OperationInputs("1,2,3", new SubtractingStrategy());
        StringCalculator calculator = new StringCalculator();
        int result = calculator.operate(testSubtractingInputs);
        assertThat(result).isEqualTo(-6);

    }
}