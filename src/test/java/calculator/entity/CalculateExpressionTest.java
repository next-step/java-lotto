package calculator.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateExpressionTest {

    @Test
    void add() {
        int result = CalculateExpression.ADD.result(3, 8);

        assertThat(result).isEqualTo(11);
    }

    @Test
    void subtract() {
        int result = CalculateExpression.SUBTRACT.result(8, 3);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void multiply() {
        int result = CalculateExpression.MULTIPLY.result(3, 8);

        assertThat(result).isEqualTo(24);
    }

    @Test
    void divide() {
        int result = CalculateExpression.DIVIDE.result(10, 2);

        assertThat(result).isEqualTo(5);
    }

}
