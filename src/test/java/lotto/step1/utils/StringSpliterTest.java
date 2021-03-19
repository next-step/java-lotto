package lotto.step1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringSpliterTest {


    @DisplayName("커스텀 문자열 split 테스트")
    @ParameterizedTest
    @MethodSource("provideCustomString")
    public void 커스텀문자열_split(String input, String[] expected) {
        assertThat(StringSpliter.splitToStringArray(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCustomString() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"}),
                Arguments.of("//!\n10!2!7", new String[]{"10", "2", "7"})
        );
    }

    @DisplayName("지정특수기호(,|:) split 테스트")
    @ParameterizedTest
    @MethodSource("provideSelectedString")
    public void 지정특수기호문자열_split(String input, String[] expected) {
        assertThat(StringSpliter.splitToStringArray(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSelectedString() {
        return Stream.of(
                Arguments.of("4,5:6", new String[]{"4", "5", "6"}),
                Arguments.of("9:1:7", new String[]{"9", "1", "7"})
        );
    }
}
