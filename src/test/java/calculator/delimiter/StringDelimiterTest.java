package calculator.delimiter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringDelimiterTest {

    private StringDelimiter stringDelimiter;

    @BeforeAll
    public void init() {
        stringDelimiter = new StringDelimiter();
    }

    @Test
    @DisplayName("기본 구분자를 포함한 문자열 분리 테스트")
    void split_by_default_delimiter_test() {
        String text = "1,2:3";
        String[] result = stringDelimiter.splitByDelimiter(text);
        assertEquals(3, result.length);
    }

    @Test
    @DisplayName("커스텀 구분자를 포함한 문자열 분리 테스트")
    void split_by_custom_delimiter_test() {
        String text = "//;\n1;2;3";
        String[] result = stringDelimiter.splitByDelimiter(text);
        assertEquals(3, result.length);
    }

}
