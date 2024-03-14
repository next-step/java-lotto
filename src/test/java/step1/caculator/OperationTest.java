package step1.caculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.calculator.Operation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step1.calculator.Operation.DIVIDE;
import static step1.calculator.Operation.MINUS;
import static step1.calculator.Operation.MULTIPLY;
import static step1.calculator.Operation.PLUS;
import static step1.calculator.Operation.find;

class OperationTest {

    @DisplayName("name에 해당하는 열거형 상수를 반환한다")
    @Test
    void valueOf() {
        Operation operation = Operation.valueOf("PLUS");
        assertThat(operation).isEqualTo(PLUS);
    }

    @Test
    void valueOfThrowException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operation.valueOf("+"));
    }

    @Test
    void values() {
        assertThat(Operation.values())
                .containsExactly(PLUS, MINUS, MULTIPLY, DIVIDE);
    }

    @ParameterizedTest(name = "사칙 연산자가 아닌 경우 예외를 던진다")
    @ValueSource(strings = {"!", "@", "#", "$", "~", "^"})
    void findThrowException(String symbol) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> find(symbol));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 0", "2 - 1", "1 * 1", "10 / 10"}, delimiter = ' ')
    void apply(int operand1, String operator, int operand2) {
        int expected = 1;

        Operation operation = find(operator);
        int actual = operation.apply(operand1, operand2);

        assertThat(actual).isEqualTo(expected);
    }
}
