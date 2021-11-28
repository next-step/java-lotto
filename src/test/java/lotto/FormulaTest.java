package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class FormulaTest {
    private final Formula dut = new Formula(new FilterCustomDelimiter(), new FilterOperands());

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @MethodSource("rawFormulaToResult")
    void calculate(String rawFormula, int result) {
        assertThat(dut.calculate(rawFormula)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @NullAndEmptySource
    void whenRawFormulaIsNullOrEmpty(String rawFormula) {
        assertThatThrownBy(() -> dut.calculate(rawFormula))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> rawFormulaToResult() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("1,2,3:4", 10)
        );
    }
}
