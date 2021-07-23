package string_add_calculator.tokenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static string_add_calculator.fixture.Fixture.DEFAULT_TOKENIZER;

@DisplayName("기본 토크나이저 클래스 테스트")
class DefaultTokenizerTest {

    @DisplayName("받아온 문자열을 , 와 : 로 쪼갠후 쪼개진 문자 배열로 반환한다.")
    @MethodSource
    @ParameterizedTest
    void split(String inputString, List<String> expectedTokens) {
        assertThat(DEFAULT_TOKENIZER.split(inputString)).containsAll(expectedTokens);
    }

    private static Stream<Arguments> split() {
        return Stream.of(
                Arguments.of("123,45,678", Arrays.asList("123", "45", "678")),
                Arguments.of("1:2:3", Arrays.asList("1", "2", "3")),
                Arguments.of("5,10:25", Arrays.asList("5", "10", "25"))
        );
    }
}
