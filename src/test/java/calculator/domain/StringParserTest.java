package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 8"})
    @DisplayName("문자열을 받아 피연산자로만 구성된 리스트로 분리한다.")
    void parseOperands_피연산자분리(String input) {
        List<Integer> operands = StringParser.parseOperands(input);
        List<Integer> expected = Arrays.asList(2, 3, 4, 8);

        assertEquals(operands, expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 8"})
    @DisplayName("문자열을 받아 연산자로만 구성된 리스트로 분리한다.")
    void parseOperators_연산자분리(String input) {
        List<String> operator = StringParser.parseOperators(input);
        List<String> expected = Arrays.asList("+", "*", "/");

        assertEquals(operator, expected);
    }
}