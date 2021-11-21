package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FilterOperandsTest {
    private final FilterOperands dut = new FilterOperands();

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @MethodSource("rawFormulaToOperands")
    void filterWithoutCustomDelimiter(String rawFormula, Collection<Integer> operands) {
        assertThat(dut.filter(rawFormula)).containsExactlyElementsOf(operands);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @MethodSource("rawFormulaAndDelimiterToOperands")
    void filterWithCustomDelimiter(String rawFormula, String delimiter, Collection<Integer> operands) {
        assertThat(dut.filter(rawFormula, delimiter)).containsExactlyElementsOf(operands);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(strings = {"1,2,-3", "1,2,&"})
    void operandMustBeZeroOrPositiveNumber(String rawFormula) {
        assertThatThrownBy(() -> dut.filter(rawFormula)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> rawFormulaToOperands() {
        return Stream.of(
                Arguments.of("//;\n1,2:3", Arrays.asList(1, 2, 3)),
                Arguments.of("1,2:3", Arrays.asList(1, 2, 3))
        );
    }

    static Stream<Arguments> rawFormulaAndDelimiterToOperands() {
        return Stream.of(
                Arguments.of("//;\n1,2;3", ";", Arrays.asList(1, 2, 3)),
                Arguments.of("//?\n1?2,3", "?", Arrays.asList(1, 2, 3)),
                Arguments.of("//_\n1,2:3,4_1", "_", Arrays.asList(1, 2, 3, 4, 1))
        );
    }
}
