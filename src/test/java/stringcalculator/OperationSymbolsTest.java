package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.DoubleBinaryOperator;

import static org.assertj.core.api.Assertions.*;

class OperationSymbolsTest {

    @DisplayName("인자로 받은 연산 기호가 (+, -, *, /)중 일치하는 것이 있는 지 확인한다.")
    @ParameterizedTest
    @CsvSource({"+,true", "-,true", "*,true", "/,true", ":,false", "=,false"})
    void validateSymbol(String symbol, boolean expectedResult) {
        // when & then
        assertThat(OperationSymbols.isOperationSymbol(symbol)).isEqualTo(expectedResult);
    }

    @DisplayName("연산 기호에 해당하는 계산식을 찾는다.")
    @ParameterizedTest
    @CsvSource({"+,9", "-,3", "*,18", "/,2"})
    void calculate(String symbol, double expectedResult) {
        // given
        double left = 6;
        double right = 3;

        // when
        DoubleBinaryOperator folmula = OperationSymbols.findFolmula(symbol);
        double realResult = folmula.applyAsDouble(left, right);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }
}