package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperationTest {
    @DisplayName("입력받은 문자가 숫자가 아닌 경우 에러를 발생한다.")
    @Test
    void 숫자가_아닌경우_에러() {
        assertThatThrownBy(() -> {
            new Operation("a", "+", "1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_NOT_NUMBER);
    }

    @DisplayName("입력받은 문자가 숫자일 경우 숫자로 변환한다.")
    @Test
    void 문자를_숫자로_변환() {
        Operation operation = new Operation("1", "+", "1");
        assertThat(operation).isNotNull();
    }

    @DisplayName("입력받은 문자가 사칙연산 기호가 아닌 경우 에러를 발생한다.")
    @Test
    void 사칙연산_기호가_아닌경우_에러() {
        assertThatThrownBy(() -> {
            new Operation("1", "x", "1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_NOT_OPERATOR_SYMBOL);
    }

    @DisplayName("숫자 2개 더하기")
    @Test
    void 덧셈() {
        Operation operation = new Operation("1", "+", "1");
        assertThat(operation.execute()).isEqualTo(2);
    }

    @DisplayName("숫자 2개 빼기")
    @Test
    void 뺄셈() {
        Operation operation = new Operation("4", "-", "1");
        assertThat(operation.execute()).isEqualTo(3);
    }

    @DisplayName("숫자 2개 곱하기")
    @Test
    void 곱셈() {
        Operation operation = new Operation("1", "*", "1");
        assertThat(operation.execute()).isEqualTo(1);
    }

    @DisplayName("숫자 2개 나누기")
    @Test
    void 나눗셈() {
        Operation operation = new Operation("5", "/", "1");
        assertThat(operation.execute()).isEqualTo(5);
    }

    @DisplayName("0으로 나눌 때 에러발생")
    @Test
    void 나눗셈_에러() {
        assertThatThrownBy(() -> {
            Operation operation = new Operation("6", "/", "0");
            operation.execute();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIVDE_ZERO_ERROR);
    }
}