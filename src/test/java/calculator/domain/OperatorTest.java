package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"3,2,5", "2,4,6"})
    void plusTest(int op1, int op2, int res) {
        Operator operator = Operator.of("+");
        assertThat(operator.calculate(op1, op2))
                .isEqualTo(res);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,2,1", "6,4,2"})
    void minusTest(int op1, int op2, int res) {
        Operator operator = Operator.of("-");
        assertThat(operator.calculate(op1, op2))
                .isEqualTo(res);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,2,6", "2,4,8"})
    void multiplyTest(int op1, int op2, int res) {
        Operator operator = Operator.of("*");
        assertThat(operator.calculate(op1, op2))
                .isEqualTo(res);
    }

    @ParameterizedTest
    @CsvSource(value = {"8,2,4", "9,3,3"})
    void divideTest(int op1, int op2, int res) {
        Operator operator = Operator.of("/");
        assertThat(operator.calculate(op1, op2))
                .isEqualTo(res);
    }

    @Test
    void divideByZeroTest() {
        Operator operator = Operator.DIVIDE;
        assertThatThrownBy(() -> operator.calculate(3, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}