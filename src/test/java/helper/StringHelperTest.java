package helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
class StringHelperTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(String input) {
        assertThat(StringHelper.nullOrEmpty(input)).isEqualTo(true);
    }

    @ParameterizedTest(name = "패턴을 포함한 split")
    @MethodSource(value = "stringPatternProvider")
    void splitByPattern(String input, String[] expected) {
        assertThat(StringHelper.splitByPattern(Pattern.compile("//(.)\n(.*)"), input)).containsExactly(expected);
    }


    @ParameterizedTest(name = "콤마 혹은 콜론을 포함한 split")
    @MethodSource(value = "stringCommaOrColonProvider")
    void splitByCommaOrColon(String input, String[] expected) {
        assertThat(StringHelper.splitByCommaOrColon(input)).containsExactly(expected);
    }

    @Test
    @DisplayName(value = "음수 변환 시, 에러를 던진다.")
    void stringToInt() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringHelper.stringToInt("-1"));
    }

    static Stream<Arguments> stringPatternProvider() {
        return Stream.of(
            Arguments.arguments("//;\n1;2;3", new String[]{"1", "2", "3"}),
            Arguments.arguments("//;\n-1;1912;3333", new String[]{"-1", "1912", "3333"})
        );
    }

    static Stream<Arguments> stringCommaOrColonProvider() {
        return Stream.of(
            Arguments.arguments("1,2:3", new String[]{"1", "2", "3"}),
            Arguments.arguments("0:1:0,4,6", new String[]{"0", "1", "0", "4", "6"})
        );
    }
}