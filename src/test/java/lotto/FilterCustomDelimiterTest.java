package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FilterCustomDelimiterTest {
    private final FilterCustomDelimiter dut = new FilterCustomDelimiter();
    @ParameterizedTest
    @MethodSource("RawStringToDelimiters")
    void filter(String rawFormula, Collection<String> expectedDelimeters) {
        assertThat(dut.filter(rawFormula)).containsExactlyElementsOf(expectedDelimeters);
    }

    @Test
    @NullAndEmptySource
    void whenRawFormulaIsNullOrEmpty(String rawFormula) {
        assertThatThrownBy(() -> dut.filter(rawFormula)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> RawStringToDelimiters() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", Arrays.asList(";")),
                Arguments.of("1;2;3", Collections.emptyList())
        );
    }
}
