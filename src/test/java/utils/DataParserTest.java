package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DataParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"p", "hello"})
    void parseStrToInt_문자열(String input) {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            DataParser.parseToInt(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-123"})
    void parseStrToInt_음수(String input) {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            DataParser.parseToInt(input);
        });
    }

}