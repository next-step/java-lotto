package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import practice.domain.Calculator;
import practice.vo.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    static Stream<String> emptySumCase() {
        return Stream.of(null, "", " ");
    }

    private static Stream<Arguments> getCustomCase() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of("//;\n1;2;3", "6"));
        argumentsList.add(Arguments.of("//.\n1.2.3", "6"));
        argumentsList.add(Arguments.of("//+\n1+2+3", "6"));
        return argumentsList.stream();
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,2,3_음수", "1&2,3_유효하지 않은 수식"}, delimiter = '_')
    void testInvalidFormula(final String formula, final String errMsg) {
        assertThatThrownBy(() -> {
            new Elements(formula);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(errMsg);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "1:2:3"})
    void testValidAndSplitFormula(final String formula) {
        assertThat(new Elements(formula)).isEqualTo(new Integer[]{1, 2, 3});
    }

    @ParameterizedTest
    @MethodSource("emptySumCase")
    void testEmptySum(final String formula) {
        assertThat(new Calculator().sum(formula))
                .isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6"}, delimiter = '=')
    void testSum(final String formula, final Integer answer) {
        assertThat(new Calculator().sum(formula)).isEqualTo(answer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//.\n1.2.3", "//+\n1+2+3"})
    void testCustomSeparatorSplit(final String formula) {
        assertThat(new Elements(formula)).isEqualTo(new Integer[]{1, 2, 3});
    }

    @ParameterizedTest
    @MethodSource("getCustomCase")
    void testCustomSeparatorSum(final String formula, final Integer answer) {
        assertThat(new Calculator().sum(formula))
                .isEqualTo(answer);
    }
}
