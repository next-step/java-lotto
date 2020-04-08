package lotto;

import lotto.domain.Calculator;
import lotto.vo.Elements;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"-1,2,3_음수", "1&2,3_유효하지 않은 수식"}, delimiter = '_')
    void testInvalidFormula(final String formula, final String errMsg) {
        assertThatThrownBy(() -> { new Elements(formula); })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(errMsg);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "1:2:3"})
    void testValidAndSplitFormula(final String formula) {
        assertThat(new Elements(formula)).isEqualTo(new Integer[] {1,2,3});
    }

    static Stream<String> emptySumCase() {
        return Stream.of(null, "", " ");
    }

    @ParameterizedTest
    @MethodSource("emptySumCase")
    void testEmptySum(String formula) {
        assertThat(Calculator.Sum(formula)).isEqualTo(0);
    }


    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6"}, delimiter = '=')
    void testSum(String formula, Integer answer) {
        assertThat(Calculator.Sum(formula)).isEqualTo(answer);
    }

    @Test
    void testCustomSeparatorSplit() {

    }

    @ParameterizedTest
    @CsvSource(value = {"//;\n1;2;3=6"}, delimiter = '=')
    void testCustomSeparatorSum() {

    }
}
