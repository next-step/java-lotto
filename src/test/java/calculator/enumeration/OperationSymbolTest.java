package calculator.enumeration;

import calculator.domain.Operand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationSymbolTest {
    @ParameterizedTest
    @CsvSource(value = {"'+':12", "'-':8", "'*':20", "'/':5"}, delimiter = ':')
    void 연산기호_계산(String input, int expected) {
        Operand left = new Operand(10);
        Operand right = new Operand(2);

        Operand operand = OperationSymbol.from(input).calculate(left, right);

        assertThat(operand).isEqualTo(new Operand(expected));
    }

    @Test
    void 기호로_연산기호_찾기() {
        assertThat(OperationSymbol.from("+")).isEqualTo(OperationSymbol.ADDITION);
    }
}