package string_add_calculator.tokenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static string_add_calculator.fixture.Fixture.CUSTOM_TOKENIZER;

@DisplayName("구분자를 자유롭게 커스터마이징 할 수 있는 커스텀 토크나이저 클래스 테스트")
class CustomTokenizerTest {

    @DisplayName("커스텀 구분자는 //와\\n 사이에 위치한다.")
    @MethodSource
    @ParameterizedTest
    void customTokenizerSplit(String customExpression, List<String> expectedToken) {
        assertThat(CUSTOM_TOKENIZER.split(customExpression)).containsAll(expectedToken);
    }

    private static Stream<Arguments> customTokenizerSplit() {
        return Stream.of(
                Arguments.of("///\n1/2/3", Arrays.asList("1", "2", "3")),
                Arguments.of("// \n1 2 3", Arrays.asList("1", "2", "3")),
                Arguments.of("//-\n1-2-3", Arrays.asList("1", "2", "3"))
        );
    }
}
