package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.domain.Operator.DIVIDE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("각 연산자 문자로 Operator를 찾는다.")
    @ParameterizedTest
    @CsvSource(value = {"+,ADD", "-,SUBTRACT", "*,MULTIPLY", "/,DIVIDE"})
    void from(String value, String name) {
        assertThat(Operator.from(value)).isEqualTo(Operator.valueOf(name));
    }

    @DisplayName("연산자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void from_not_operator() {
        ThrowingCallable actual = () -> Operator.from(".");

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자(+,-,*,/)의 위치에 연산자가 아닌 값이 입력되었습니다.");
    }

    @DisplayName("각 연산자에 대한 연신을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"ADD,4,2,6", "SUBTRACT,4,2,2", "MULTIPLY,4,2,8", "DIVIDE,4,2,2"})
    void operate(String operator, int firstNumber, int secondNumber, int expected) {
        int actual = Operator.valueOf(operator).operate(firstNumber, secondNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("나누기 연산자 뒤의 숫자가 0이면 예외가 발생한다.")
    @Test
    void operate_no_zero_after_divide() {
        assertThatThrownBy(() -> DIVIDE.operate(1, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("'/'(나누기 연산자) 뒤의 숫자는 0일 수 없습니다.");
    }
}
