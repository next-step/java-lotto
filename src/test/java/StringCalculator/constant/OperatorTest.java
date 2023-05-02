package StringCalculator.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

    @Test
    void addTest() {
        assertThat(Operator.ADD.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void subtractTest() {
        assertThat(Operator.SUBTRACT.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        assertThat(Operator.MULTIPLY.calculate(2, 3)).isEqualTo(6);
    }

    @Test
    void divideTest() {
        assertThat(Operator.DIVIDE.calculate(6, 2)).isEqualTo(3);
    }

    @Test
    void divideZeroTest() {
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(1, 0))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage("/ by zero");
    }

    @ParameterizedTest
    @CsvSource({"+,ADD", "-,SUBTRACT", "*,MULTIPLY", "/,DIVIDE"})
    void toOperatorTest(String input, Operator expected) {
        assertThat(Operator.toOperator(input)).isEqualTo(expected);
    }

    @Test
    void toOperatorIllegalTest() {
        assertThatThrownBy(() -> Operator.toOperator("="))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
