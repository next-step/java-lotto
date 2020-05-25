package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @DisplayName("콤마(,)또는 콜론(:) 구분자로 문자열을 분할하여 숫자 배열을 반환한다")
    @MethodSource("provideStringsForDelimiter")
    @ParameterizedTest
    void split_NumberWithDelimiter_Tokens(String formula, Integer expectedFirst, Integer expectedSecond) {
        Integer[] tokens = Splitter.split(Formula.valueOf(formula));

        assertThat(tokens).hasSize(2);
        assertThat(tokens[0]).isEqualTo(expectedFirst);
        assertThat(tokens[1]).isEqualTo(expectedSecond);
    }

    private static Stream<Arguments> provideStringsForDelimiter() {
        return Stream.of(
                Arguments.of("1,2", 1, 2),
                Arguments.of("4,5", 4, 5),
                Arguments.of("3,1", 3, 1),
                Arguments.of("5:5", 5, 5),
                Arguments.of("2:9", 2, 9)
        );
    }

    @DisplayName("// 과 \n 사이에 있는 커스텀 구분자로 문자열을 분할하여 숫자 배열을 반환한다")
    @MethodSource("provideStringsForCustomDelimiter")
    @ParameterizedTest
    void split_NumberWithCustomDelimiter_Tokens(String formula, Integer expectedFirst, Integer expectedSecond) {
        Integer[] tokens = Splitter.split(Formula.valueOf(formula));

        assertThat(tokens).hasSize(2);
        assertThat(tokens[0]).isEqualTo(expectedFirst);
        assertThat(tokens[1]).isEqualTo(expectedSecond);
    }

    private static Stream<Arguments> provideStringsForCustomDelimiter() {
        return Stream.of(
                Arguments.of("//*\n1*2", 1, 2),
                Arguments.of("//;\n4;5", 4, 5),
                Arguments.of("//+\n3+1", 3, 1)
        );
    }
}
