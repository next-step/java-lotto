package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterUtilsTest {

    @DisplayName("빈 문자열 입력 확인 테스트")
    @Test
    void isEmpty_test() {
        assertThat(DelimiterUtils.isEmpty(null)).isTrue();
        assertThat(DelimiterUtils.isEmpty("")).isTrue();
        assertThat(DelimiterUtils.isEmpty("fullText")).isFalse();
    }

    @DisplayName("문자열 분리자 체크 필요 여부 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,3:1|false", "1:4:5|false", "//;\\n1;2;3|true"}, delimiter = '|')
    void needDelimiterFinder_test(String input, boolean result) {
        DelimiterUtils delimiterUtils = DelimiterUtils.create(input);

        assertThat(delimiterUtils.needDelimiterFinder()).isEqualTo(result);
    }

    @DisplayName("문자열 분리자 체크 필요 여부 확인 테스트")
    @ParameterizedTest
    @MethodSource("makeTestString")
    void findDelimiters_test(String input, String delimiter) {
        assertThat(DelimiterUtils.findDelimiters(input)).isEqualTo(delimiter);
    }

    private static Stream<Arguments> makeTestString() {
        return Stream.of(
                Arguments.of("3,4:5", ",|:"),
                Arguments.of("//(\n5(5", "("),
                Arguments.of("//-\n1-2-3-4", "-"),
                Arguments.of("//*\n7*1*7", "*")
        );
    }

}
