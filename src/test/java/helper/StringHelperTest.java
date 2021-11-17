package helper;

import constant.CalculatorConstant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class StringHelperTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void null_or_empty(String input) {
        assertThat(StringHelper.nullOrEmpty(input)).isEqualTo(true);
    }

    @ParameterizedTest(name = "패턴을 포함한 split")
    @MethodSource(value = "stringProvider")
    public void split_by_pattern(String input, String[] expected) {
        assertThat(StringHelper.splitByPattern(CalculatorConstant.CUSTOM_DELIMITER_PATTERN, input)).containsExactly(expected);
    }

    static Stream<Arguments> stringProvider() {
        return Stream.of(
            Arguments.arguments("//;\n1;2;3", new String[]{"1", "2", "3"}),
            Arguments.arguments("//;\n-1;1912;3333", new String[]{"-1", "1912", "3333"})
        );
    }
}