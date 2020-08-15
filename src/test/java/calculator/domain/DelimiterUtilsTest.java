package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterUtilsTest {

    @DisplayName("문자열 구분자 추출 테스트")
    @ParameterizedTest
    @MethodSource("makeInput")
    void findDelimiters_test(String input, String delimiter) {
        assertThat(DelimiterUtils.findDelimiters(input)).isEqualTo(delimiter);
    }

    private static Stream<Arguments> makeInput() {
        return Stream.of(
                Arguments.of("3,4:5", ",|:"),
                Arguments.of("//(\n5(5", "\\("),
                Arguments.of("//;\n6;1;3", ";"),
                Arguments.of("//-\n1-2-3-4", "\\-"),
                Arguments.of("//*\n7*1*7", "\\*")
        );
    }

    @DisplayName("커스텀 구분자 필터 테스트")
    @ParameterizedTest
    @MethodSource("makeCustomDelimiterInput")
    void filterCustomDelimiter_test(String input, String filteredInput) {
        assertThat(DelimiterUtils.filterCustomDelimiter(input)).isEqualTo(filteredInput);
    }

    private static Stream<Arguments> makeCustomDelimiterInput() {
        return Stream.of(
                Arguments.of("//(\n5(5", "5(5"),
                Arguments.of("//-\n1-2-3-4", "1-2-3-4"),
                Arguments.of("//*\n7*1*7", "7*1*7")
        );
    }

}
