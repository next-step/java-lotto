package calculator;

import calculator.exception.OperationErrorCode;
import exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperationTest {

    @DisplayName("주어진 두 수를 더한다")
    @Test
    void plus() {
        int result = Operation.PLUS.apply(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("주어진 두 수를 뺀다")
    @Test
    void minus() {
        int result = Operation.MINUS.apply(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("주어진 두 수를 곱한다")
    @Test
    void times() {
        int result = Operation.TIMES.apply(2, 4);
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("주어진 두 수를 나눈다")
    @Test
    void divide() {
        int result = Operation.DIVIDE.apply(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("입력한 연산기호에 맞는 Operation을 반환한다")
    @Test
    void valueOfSymbol() {
        Operation operation = Operation.valueOfSymbol("+");
        int result = operation.apply(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("정해지지 않은 연산기호 입력시 테스트가 실패한다")
    @Test
    void no_exist() {
        assertThatThrownBy(() -> Operation.valueOfSymbol("{"))
                .isInstanceOf(CustomException.class)
                .hasMessage(OperationErrorCode.NOT_OPERATION_SYMBOL.getMessage());
    }
}
