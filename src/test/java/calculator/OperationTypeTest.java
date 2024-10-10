package calculator;

import org.assertj.core.api.Assertions;
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
}
