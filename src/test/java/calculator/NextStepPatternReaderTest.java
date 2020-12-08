package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("넥스트스탭 패턴 판독기(NextStepPatternReader) 테스트")
public class NextStepPatternReaderTest {

    @DisplayName("기본 구분자(, or :)로 판독할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {",", ":"})
    void basic(String delimiter) {
        // given
        int first = 4;
        int second = 5;
        String pattern = first + delimiter + second;

        // when
        PatternReader nextStepReader = new NextStepPatternReader();
        Numbers read = nextStepReader.read(pattern);

        // then
        assertThat(read).isEqualTo(Numbers.of(first, second));
    }

    @DisplayName("커스텀 구분자로 판독할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "T", ":"})
    void custom(String delimiter) {
        // given
        int first = 4;
        int second = 5;
        String prefix = "//" + delimiter + "\n";
        String body = first + delimiter + second;

        // when
        PatternReader nextStepReader = new NextStepPatternReader();
        Numbers read = nextStepReader.read(prefix + body);

        // then
        assertThat(read).isEqualTo(Numbers.of(first, second));
    }

    @DisplayName("숫자 이외의 값을 전달하는 경우 예외처리를 한다.")
    @Test
    void notAllowNoneNumber() {
        // given
        String value = "a,b,c";
        PatternReader patternReader = new NextStepPatternReader();

        // when / then
        assertThrows(RuntimeException.class, () -> patternReader.read(value));
    }

    @DisplayName("음수를 전달하는 경우 예외처리를 한다.")
    @Test
    void notAllowNegative() {
        // given
        String value = "-1,5,3";
        PatternReader patternReader = new NextStepPatternReader();

        // when / then
        assertThrows(RuntimeException.class, () -> patternReader.read(value));
    }
}
