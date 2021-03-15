package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.calculator.pattern.CustomPattern;
import study.calculator.pattern.DefaultPattern;
import study.calculator.pattern.PatternSeparator;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    private static Stream<Arguments> strategySeparateNumbers() {
        return Stream.of(
                Arguments.of("1,2:3", new DefaultPattern(), new Integer[]{1, 2, 3}),
                Arguments.of("//;\n3;4;5", new CustomPattern(), new Integer[]{3, 4, 5}),
                Arguments.of("//#\n7#8#9", new CustomPattern(), new Integer[]{7, 8, 9})
        );
    }

    @DisplayName("일급 컬렉션 전략에 따른 문자열 분리 테스트")
    @ParameterizedTest(name = "{0} 문자열을 {1} 전략에 따라 더하기")
    @MethodSource(value = "strategySeparateNumbers")
    void getExtractNumbers_전략에_따른_문자열분리(String given, PatternSeparator patternSeparator, Integer[] expected) {
        // given

        // when
        List<Number> extractNumberList = Numbers.of(given).getExtractNumbers(given, patternSeparator);
        List<Integer> result = extractNumberList.stream()
                .map(Number::getNumber)
                .collect(toList());
        // then
        assertThat(result).contains(expected);

    }
}
