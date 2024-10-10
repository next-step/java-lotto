package calculator;

import calculator.domain.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.domain.Operation.DIVDE_ZERO_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperationTest {
    @DisplayName("숫자 2개 더하기")
    @Test
    void 덧셈() {
        Operation operation = new Operation(1, "+", 1);
        assertThat(operation.execute()).isEqualTo(2);
    }

    @DisplayName("숫자 2개 빼기")
    @Test
    void 뺄셈() {
        Operation operation = new Operation(4, "-", 1);
        assertThat(operation.execute()).isEqualTo(3);
    }

    @DisplayName("숫자 2개 곱하기")
    @Test
    void 곱셈() {
        Operation operation = new Operation(1, "*", 1);
        assertThat(operation.execute()).isEqualTo(1);
    }

    @DisplayName("숫자 2개 나누기")
    @Test
    void 나눗셈() {
        Operation operation = new Operation(5, "/", 1);
        assertThat(operation.execute()).isEqualTo(5);
    }

    @DisplayName("0으로 나눌 때 에러발생")
    @Test
    void 나눗셈_에러() {
        assertThatThrownBy(() -> {
            Operation operation = new Operation(6, "/", 0);
            operation.execute();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIVDE_ZERO_ERROR);
    }
}
