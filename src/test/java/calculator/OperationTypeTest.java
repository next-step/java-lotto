package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperationTypeTest {
    @ParameterizedTest
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE", "!:UNKNOWN"}, delimiter = ':')
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
}
