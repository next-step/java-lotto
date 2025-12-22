package calculator.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 빈_문자열_null_체크(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Parser.parse(input);
        });
    }
}
