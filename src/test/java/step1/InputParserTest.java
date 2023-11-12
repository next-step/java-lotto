package step1;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    public void 널_값_입력_시_에러_반환_테스트() {
        String userInput = null;

        assertThatThrownBy(() -> inputParser.splitUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "\t", "\t\n", "\n   \t "})
    public void 빈_문자열_입력_시_에러_반환_테스트(String userInput) {
        assertThatThrownBy(() -> inputParser.splitUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
