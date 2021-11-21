package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterCustomDelimiterTest {
    private final FilterCustomDelimiter dut = new FilterCustomDelimiter();
    @ParameterizedTest
    @MethodSource("rawFormulaToDelimiter")
    void filter(String rawFormula, String expectedDelimeter) {
        assertThat(dut.filter(rawFormula)).isEqualTo(expectedDelimeter);
    }

    static Stream<Arguments> rawFormulaToDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", ";"),
                Arguments.of("1,2,3", null)
        );
    }
}
