package study.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultPatternTest {

    private static Stream<Arguments> defaultEntry() {
        return Stream.of(
            Arguments.of("1,2:2", new String[]{"1", "2", "2"}),
            Arguments.of("4,3,2", new String[]{"4", "3", "2"})
        );
    }

    @ParameterizedTest(name = "{0} 문자열을 기본 구분자로 분리한 결과 값 {1}")
    @MethodSource(value = "defaultEntry")
    void matches_문자열분리(String given, String[] expected) {
        // given
        DefaultPattern defaultPattern = new DefaultPattern();
        // when
        String[] matches = defaultPattern.matches(given);
        // then
        assertThat(matches).containsExactly(expected);
    }
}
