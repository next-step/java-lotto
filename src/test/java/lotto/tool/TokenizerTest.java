package lotto.tool;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exceptions.InvalidPatternException;

public class TokenizerTest {

    @DisplayName("빈 문자열 또는 null 값이면 참이다.")
    @Test
    void isEmpty_True() {
        assertThat(Tokenizer.isEmpty("")).isTrue();
        assertThat(Tokenizer.isEmpty(null)).isTrue();
    }

    private static Stream<Arguments> captureNumbers_WithDelimiters_Success() {
        return Stream.of(
            Arguments.of("1", Collections.singletonList("1")),
            Arguments.of("1,2", Arrays.asList("1", "2")),
            Arguments.of("1,2:3", Arrays.asList("1", "2", "3")),
            Arguments.of("//;\\n1,2:3;4", Arrays.asList("1", "2", "3", "4"))
        );
    }

    @DisplayName("문자열을 숫자 목록으로 변환한다.")
    @ParameterizedTest(name = "입력: \"{0}\", 숫자 목록: \"{1}\"")
    @MethodSource
    void captureNumbers_WithDelimiters_Success(String input, List<String> expected) {
        assertThat(Tokenizer.captureNumbers(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> captureNumbers_WithMetaCharacter_Success() {
        return Stream.of(
            Arguments.of("//*\\n1*2", Arrays.asList("1", "2")),
            Arguments.of("//+\\n1+2+3", Arrays.asList("1", "2", "3"))
        );
    }

    @DisplayName("문자열 변환 처리 중 Meta Character 구분자를 처리한다.")
    @ParameterizedTest(name = "입력: \"{0}\", 숫자 목록: \"{1}\"")
    @MethodSource
    void captureNumbers_WithMetaCharacter_Success(String input, List<String> expected) {
        assertThat(Tokenizer.captureNumbers(input)).isEqualTo(expected);
    }

    @DisplayName("패턴에 알맞지 않은 문자열 입력은 처리를 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"a", "-1", "//;\\n1=2"})
    void captureNumbers_InvalidPattern_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidPatternException.class).isThrownBy(() -> {
            Tokenizer.captureNumbers(input);
        });
    }
}
