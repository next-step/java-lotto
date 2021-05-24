package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    private static final String[] NOT_EXPECTED = new String[] {"1", "2", "3", "4"};

    private static Stream<Arguments> splitByComma() {
        return Stream.of(
            Arguments.of("1", new String[] {"1"}),
            Arguments.of("1,2", new String[] {"1", "2"}),
            Arguments.of("1,22,333", new String[] {"1", "22", "333"})
        );
    }

    @DisplayName("쉼표를 기준으로 문자열을 분리한다.")
    @ParameterizedTest(name = "\"{0}\"는 {1}으로 변환한다.")
    @MethodSource
    void splitByComma(String input, String[] expected) {
        assertThat(input.split(",")).isEqualTo(expected);
        assertThat(input.split(",")).isNotEqualTo(NOT_EXPECTED);
    }

    @DisplayName("괄호를 제거한다.")
    @ParameterizedTest(name = "\"{0}\"는 \"{1}\"으로 변환한다.")
    @CsvSource(value = {"(1):1", "(1,2):1,2", "(1,22,333):1,22,333"}, delimiter = ':')
    void removeBrackets(String input, String expected) {
        assertThat(input.substring(1, input.length() - 1)).isEqualTo(expected);
    }

    @DisplayName("인덱스가 2인 문자를 가져온다.")
    @ParameterizedTest(name = "\"{0}\"에서 인덱스가 2인 문자 {1}를 가져온다.")
    @CsvSource(value = {"abc:c", "abcd:c"}, delimiter = ':')
    void charAt2(String input, char expected) {
        assertThat(input.charAt(2)).isEqualTo(expected);
    }

    @DisplayName("문자열 범위를 벗어나 에러가 발생한다.")
    @ParameterizedTest(name = "\"{0}\"의 9999번째 문자를 가져온다.")
    @ValueSource(strings = {"abc", "abcd"})
    void charAt9999(String input) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            input.charAt(9999);
        }).withMessageMatching("String index out of range: \\d+");
    }

}
