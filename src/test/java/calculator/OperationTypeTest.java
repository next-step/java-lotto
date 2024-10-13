package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperationTypeTest {
    @ParameterizedTest
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void 심볼로_타입_생성(String symbol, OperationType expected) {
        // when
        OperationType result = OperationType.fromSymbol(symbol);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void 덧셈_수행() {
        // given
        int operandA = 3;
        int operandB = 1;

        // when
        int result = OperationType.ADD.apply(operandA, operandB);

        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    void 뺄셈_수행() {
        // given
        int operandA = 3;
        int operandB = 1;

        // when
        int result = OperationType.SUBTRACT.apply(operandA, operandB);

        // then
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱셈_수행() {
        // given
        int operandA = 3;
        int operandB = 2;

        // when
        int result = OperationType.MULTIPLY.apply(operandA, operandB);

        // then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈_수행() {
        // given
        int operandA = 3;
        int operandB = 2;

        // when
        int result = OperationType.DIVIDE.apply(operandA, operandB);

        // then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 나눗셈_0으로_나눌수_없음() {
        // given
        int operandA = 3;
        int operandB = 0;

        // when, then
        Assertions.assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            OperationType.DIVIDE.apply(operandA, operandB);
        }).withMessage("0으로 나눌 수 없습니다");
    }

    @Test
    void 타입_생성_유효하지_않은_연산자_입력_시_예외_발생() {
        // given
        String symbol = "!";

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> OperationType.fromSymbol(symbol))
                .withMessage("유효하지 않은 연산자가 입력되었습니다");
    }
}
