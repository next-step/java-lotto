package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step1.Operation.PLUS;

class OperationTest {

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

    @ParameterizedTest(name = "사칙 연산자가 아닌 경우 예외를 던진다")
    @ValueSource(strings = {"!", "@", "#", "$", "~", "^"})
    void findThrowException(String symbol) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operation.find(symbol));
    }

    @Test
    void performOperation() {
        int operand1 = 1;
        String operator = "+";
        int operand2 = 1;

        int actual = Operation.performOperation(operand1, operator, operand2);
        int expected = 2;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사칙 연산자가 아닌 경우 예외를 던진다")
    @Test
    void performOperationThrowException() {
        int operand1 = 1;
        String symbol = "!";
        int operand2 = 2;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operation.performOperation(operand1, symbol, operand2))
                .withMessage("유효하지 않은 연산자 입니다 : " + symbol);
    }
}
