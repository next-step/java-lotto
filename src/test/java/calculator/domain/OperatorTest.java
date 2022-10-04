package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+,ADD", "-,SUBTRACT", "*,MULTIPLY", "/,DIVIDE"})
    void of(String value, String name) {
        assertThat(Operator.of(value)).isEqualTo(Operator.valueOf(name));
    }

    @Test
    void of_not_operator_value() {
        ThrowingCallable actual = () -> Operator.of(".");

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자(+,-,*,/)의 위치에 연산자가 아닌 값이 입력되었습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"ADD,4,2,6", "SUBTRACT,4,2,2", "MULTIPLY,4,2,8", "DIVIDE,4,2,2"})
    void operate(String operator, int firstNumber, int secondNumber, int expected) {
        int actual = Operator.valueOf(operator).operate(firstNumber, secondNumber);

        assertThat(actual).isEqualTo(expected);
    }
}
