package calculator.enumeration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationSymbolTest {
    @ParameterizedTest
    @CsvSource(value = {"'+':12", "'-':8", "'*':20", "'/':5"}, delimiter = ':')
    void 연산기호_계산(String input, int expected) {
        OperationSymbol operationSymbol = OperationSymbol.from(input);
        assertThat(operationSymbol.calculate(10, 2)).isEqualTo(expected);
    }

    @Test
    void 기호로_연산기호_찾기() {
        assertThat(OperationSymbol.from("+")).isEqualTo(OperationSymbol.ADDITION);
    }
}