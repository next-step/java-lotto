package stringcalculator.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.expression.Delimiter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionExtractorTest {

    @DisplayName("구분자 구하기 - 기본 구분자")
    @Test
    void extractDelimiter() {
        String expression = "1:2";

        //when
        Delimiter actual = ExpressionExtractor.extractDelimiter(expression);

        //then
        Delimiter expected = Delimiter.newInstance();
        assertEquals(expected, actual);
    }

    @DisplayName("구분자 구하기 - 사용자 정의 구분자")
    @Test
    void extractCustomDelimiter() {
        String expression = "//.\\n1.2";
        String delimiter = ".";

        //when
        Delimiter actual = ExpressionExtractor.extractDelimiter(expression);

        //then
        Delimiter expected = Delimiter.newInstance(delimiter);
        assertEquals(expected, actual);
    }

    @DisplayName("구분자 구하기 - 기본 구분자")
    @Test
    void extractDefaultDelimiter() {
        String expression = "1:2";

        //when
        Delimiter actual = ExpressionExtractor.extractDelimiter(expression);

        //then
        Delimiter expected = Delimiter.newInstance();
        assertEquals(expected, actual);
    }

    @DisplayName("custom delimter 제외한 수식 반환")
    @ParameterizedTest
    @CsvSource(value = {"//.\\n1.2:1.2", "1,2:1,2"}, delimiter = ':')
    void extractExpression(String values, String expected) {
        //when
        String actual = ExpressionExtractor.extractNumbers(values);

        //then
        assertEquals(expected, actual);
    }
}
