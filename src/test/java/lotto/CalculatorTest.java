package lotto;

import lotto.vo.Elements;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6"}, delimiter = '=')
    void testSum(String formula, Integer answer) {

    }

    @Test
    void testCustomSeparatorSplit() {

    }

    @ParameterizedTest
    @CsvSource(value = {"//;\n1;2;3=6"}, delimiter = '=')
    void testCustomSeparatorSum() {

    }
}
