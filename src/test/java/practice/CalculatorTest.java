package practice;

import practice.domain.Calculator;
import practice.vo.Elements;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
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
    void testEmptySum(final String formula) {
        assertThat(Calculator.Sum(formula)).isEqualTo(0);
    }


    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6"}, delimiter = '=')
    void testSum(final String formula, final Integer answer) {
        assertThat(Calculator.Sum(formula)).isEqualTo(answer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//.\n1.2.3", "//+\n1+2+3"})
    void testCustomSeparatorSplit(final String formula) {
        assertThat(new Elements(formula)).isEqualTo(new Integer[] {1,2,3});
    }

    private static Stream<Arguments> getCustomCase() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("//;\n1;2;3","6"));
        argumentsList.add(Arguments.of("//.\n1.2.3","6"));
        argumentsList.add(Arguments.of("//+\n1+2+3","6"));
        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("getCustomCase")
    void testCustomSeparatorSum(final String formula, final Integer answer) {
        assertThat(Calculator.Sum(formula)).isEqualTo(answer);
    }
}
