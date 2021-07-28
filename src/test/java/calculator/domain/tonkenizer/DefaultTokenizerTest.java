package calculator.domain.tonkenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("기본 토크나이저 클래스 테스트")
class DefaultTokenizerTest {

    @DisplayName("받아온 문자열을 , 와 : 로 분리한후 문자 배열로 반환한다.")
    @MethodSource
    @ParameterizedTest
    void can_split(String input, List<String> expectedTokens) {
        //arrange
        DefaultTokenizer tokenizer = new DefaultTokenizer();

        //act, assert
        assertThat(tokenizer.split(input)).containsAll(expectedTokens);
    }

    private static Stream<Arguments> can_split() {
        return Stream.of(
                Arguments.of("1:2:3", Arrays.asList("1", "2", "3")),
                Arguments.of("1,2:3", Arrays.asList("1", "2", "3"))
        );
    }
}
