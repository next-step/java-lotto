package step1.calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    @DisplayName("+ 연산 테스트")
    void given_plus_operation_when_calculate_then_return_sum() {
        // given
        Operation operation = Operation.ADD;
        int x = 2;
        int y = 3;

        // when
        int result = operation.calculate(x, y);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("- 연산 테스트")
    void given_minus_operation_when_calculate_then_return_subtraction() {
        // given
        Operation operation = Operation.SUBTRACT;
        int x = 2;
        int y = 3;

        // when
        int result = operation.calculate(x, y);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("* 연산 테스트")
    void given_multiply_operation_when_calculate_then_return_multiplication() {
        // given
        Operation operation = Operation.MULTIPLY;
        int x = 2;
        int y = 3;

        // when
        int result = operation.calculate(x, y);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("/ 연산 테스트")
    void given_divide_operation_when_calculate_then_return_division() {
        // given
        Operation operation = Operation.DIVIDE;
        int x = 6;
        int y = 3;

        // when
        int result = operation.calculate(x, y);

        // then
        assertThat(result).isEqualTo(2);
    }

}
