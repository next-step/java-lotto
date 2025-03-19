package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DivideOperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"2:1:2", "12:4:3", "21:3:7"}, delimiter = ':')
    void 연산_확인(int left, int right, int result){
        DivideOperator operator = new DivideOperator();
        assertThat(operator.operate(left, right)).isEqualTo(result);
    }

    @Test
    void 나누기_0() {
        DivideOperator operator = new DivideOperator();
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    operator.operate(1, 0);
                }).withMessageMatching("Division by zero");
    }

    @Test
    void 나누어떨어지지_않음() {
        DivideOperator operator = new DivideOperator();
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    operator.operate(3, 2);
                }).withMessageMatching("The division does not result in an integer.");
    }
}
