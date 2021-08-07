package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        StringTokenizer tokenizer = new StringTokenizer();
        StringParser stringParser = new StringParser();
        stringCalculator = new StringCalculator(tokenizer, stringParser);
    }

    @ParameterizedTest
    @DisplayName("기본 구분자로 덧셈 테스트")
    @CsvSource(value = {"null,0", "'',0", "'1,2',3", "'1,2,3',6"}, nullValues = "null")
    public void defaultDelimiterTest(String input, int expected) {
        int actual = stringCalculator.add(input);
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 덧셈 테스트")
    @CsvSource(value = {"null,0", "'',0", "'//-\n1-2',3", "'//-\n1-2-3',6"}, nullValues = "null")
    public void customDelimiterTest(String input, int expected) {
        int actual = stringCalculator.add(input);
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("음수가 존재하는 경우 RuntimeExcpetion 테스트")
    public void runtimeExceptionTest() {
        String input = "1,-1,10";
        assertThrows(RuntimeException.class, () -> stringCalculator.add(input));
    }
}
