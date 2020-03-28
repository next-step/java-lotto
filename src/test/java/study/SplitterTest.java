package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.calculator.domain.Splitter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @DisplayName("기본 구분자를 이용한 분리")
    @ParameterizedTest
    @MethodSource("provideDefaultInput")
    void defaultSeparator(String text, List<String> result) {
        assertThat(Splitter.split(text)).isEqualTo(result);
    }

    @DisplayName("커스텀 구분자를 이용한 분리")
    @ParameterizedTest
    @MethodSource("provideCustomInput")
    void customSeparator(String text, List<String> result) {
        assertThat(Splitter.split(text)).isEqualTo(result);
    }

    @DisplayName("공백 입력")
    @Test
    void empty() {
        assertThat(Splitter.split("")).isEqualTo(Collections.singletonList(""));
    }

    @DisplayName("null 입력")
    @Test
    void nullValue() {
        assertThat(Splitter.split(null)).isEqualTo(Collections.emptyList());
    }

    private static Stream<Arguments> provideDefaultInput() {
        return Stream.of(
                Arguments.of("a,b", Arrays.asList("a", "b")),
                Arguments.of("1:2", Arrays.asList("1", "2")),
                Arguments.of("1,2:tt", Arrays.asList("1", "2", "tt"))
        );
    }

    private static Stream<Arguments> provideCustomInput() {
        return Stream.of(
                Arguments.of("//?\\na?b", Arrays.asList("a", "b")),
                Arguments.of("//!!\\n1!!22", Arrays.asList("1", "22")),
                Arguments.of("//?\\n1,2?tt", Arrays.asList("1", "2", "tt"))
        );
    }
}
