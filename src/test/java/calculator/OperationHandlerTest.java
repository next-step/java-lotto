package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.ErrorMessage.INPUT_IS_NOT_NUMBER;
import static calculator.ErrorMessage.INPUT_IS_NOT_OPERATOR_SYMBOL;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperationHandlerTest {

    @DisplayName("입력받은 큐들을 계산할 수 있다.")
    @Test
    void 총_계산() {
        OperationHandler operationHandler =  new OperationHandler(new String[]{"1", "+", "1","*","4"});
        assertThat(operationHandler.calculate()).isEqualTo(8);
    }

    @DisplayName("입력받은 문자가 숫자가 아닌 경우 에러를 발생한다.")
    @Test
    void 숫자가_아닌경우_에러() {
        OperationHandler operationHandler = new OperationHandler(new String[]{"a", "+", "1"});
        assertThatThrownBy(() -> {
            operationHandler.calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_NOT_NUMBER);
    }

    @DisplayName("입력받은 문자가 숫자일 경우 숫자로 변환한다.")
    @Test
    void 문자를_숫자로_변환() {
        OperationHandler operationHandler = new OperationHandler(new String[]{"1", "+", "1"});
        assertThat(operationHandler.calculate()).isEqualTo(2);
    }

    @DisplayName("입력받은 문자가 사칙연산 기호가 아닌 경우 에러를 발생한다.")
    @Test
    void 사칙연산_기호가_아닌경우_에러() {
        OperationHandler operationHandler = new OperationHandler(new String[]{"1", "x", "1"});
        assertThatThrownBy(() -> {
            operationHandler.calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_NOT_OPERATOR_SYMBOL);
    }
}