package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

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
}
