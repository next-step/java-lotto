package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringExpressionConverterTest {

    static Stream<Arguments> originExpressions() {
        return Stream.of(
                Arguments.of("1,2:3", Arrays.asList("1", "2", "3")),
                Arguments.of("5,2,1,7", Arrays.asList("5", "2", "1", "7")),
                Arguments.of("1:2:3", Arrays.asList("1", "2", "3"))
        );
    }

    static Stream<Arguments> customExpressions() {
        return Stream.of(
                Arguments.of("//@\n1@2@3", Arrays.asList("1", "2", "3")),
                Arguments.of("//!\n5!2!1!7", Arrays.asList("5", "2", "1", "7")),
                Arguments.of("//a\n1a2a3", Arrays.asList("1", "2", "3"))
        );
    }

    @DisplayName("커스텀 구분자가 아닌 문자열을 입력하면 . 또는 :를 기준으로 분할하여 반환한다")
    @MethodSource("originExpressions")
    @ParameterizedTest
    public void originCalculate(String input, List<String> expected) {
        List<String> result = StringExpressionConverter.convert(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(" //와 \\n 사이에 커스텀구분자를 지정하면 해당 구분자로 분할하여 반환한다 ")
    @MethodSource("customExpressions")
    @ParameterizedTest
    public void customTest(String input, List<String> expected) {
        List<String> result = StringExpressionConverter.convert(input);

        assertThat(result).isEqualTo(expected);
    }

}