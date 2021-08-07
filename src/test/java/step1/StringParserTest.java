package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringParserTest {

    private StringParser parser = new StringParser();

    @ParameterizedTest
    @DisplayName("음수인 경우 RuntimeException이 발생한다")
    @ValueSource(strings = {"-10", "-5", "-1"})
    void parseExceptionWhenInputIsLessThanZero(String input) {
        assertThrows(RuntimeException.class, () -> parser.parseToInt(input));
    }

    @ParameterizedTest
    @DisplayName("음수가 아닌 경우 parsing 된다")
    @ValueSource(strings = {"0", "1", "10"})
    void parseToInt(String input) {
        assertDoesNotThrow(() -> parser.parseToInt(input));
    }
}