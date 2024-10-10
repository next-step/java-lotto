package calculator.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ExpressionTest {

    private final Expression add = new Expression(CalculateExpression.ADD);
    private final Expression subtract = new Expression(CalculateExpression.SUBTRACT);
    private final Expression multiply = new Expression(CalculateExpression.MULTIPLY);
    private final Expression divide = new Expression(CalculateExpression.DIVIDE);

    @Test
    void add() {
        int result = add.result(3, 6);

        assertThat(result).isEqualTo(9);
    }

    @Test
    void subtract() {
        int result = subtract.result(10, 6);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void multiply() {
        int result = multiply.result(3, 6);

        assertThat(result).isEqualTo(18);
    }

    @Test
    void divide() {
        int result = divide.result(10, 2);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void match() {
        assertAll(
                () -> assertThat(add.isMatch("+")).isTrue(),
                () -> assertThat(subtract.isMatch("-")).isTrue(),
                () -> assertThat(multiply.isMatch("*")).isTrue(),
                () -> assertThat(divide.isMatch("/")).isTrue()
        );
    }

}
