package string_add_calculator.tokenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("식을 토큰화 시켜주는 클래스 테스트")
class ExpressionTokenizerTest {

    @DisplayName("식을 넘겨주면 토큰화 된 문자 배열을 넘겨준다.")
    @MethodSource
    @ParameterizedTest
    void split(String inputString, List<String> expectedTokens) {
        assertThat(ExpressionTokenizer.split(inputString)).containsAll(expectedTokens);
    }

    private static Stream<Arguments> split() {
        return Stream.of(
                Arguments.of("123,45,678", Arrays.asList("123", "45", "678"))
        );
    }
}
