package dev.dahye.learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Matcher 학습 테스트")
public class MatcherTest {
    private static final String REGEX = "//(.)\n(.*)";
    private static final int TARGET_INDEX = 1;

    @ParameterizedTest(name = "input = {0}, result = {1}")
    @CsvSource({"'//;\n', ;", "'//?\n', ?", "'//;\n3', ;", "'//;\n3;4', ;"})
    @DisplayName("Match 성공 케이스")
    void matcher_success(String input, String expected) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        assertTrue(m.matches());
        assertEquals(expected, m.group(TARGET_INDEX));
    }

    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"test", ";", "//?", "//;\n//;\n1;2;3"})
    @DisplayName("Match 실패 케이스")
    void matcher_fail(String input) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        assertFalse(m.matches());
        assertThrows(IllegalStateException.class, () -> m.group(TARGET_INDEX));
    }

    @ParameterizedTest(name = "input = {0}, result = {1}")
    @ValueSource(strings = {"//;\n//;\n1;2;3"})
    @DisplayName("Matcher의 matches()는 전체 문자열이 표현식과 일치하지 않으면 false를 return 한다.")
    void matcher_matches_true(String input) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        assertFalse(m.matches());
    }

    @ParameterizedTest(name = "input = {0}, result = {1}")
    @ValueSource(strings = {"//;\n1;2;3"})
    @DisplayName("Matcher의 matches()는 전체 문자열이 표현식과 일치할 때 true를 return 한다.")
    void matcher_matches(String input) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        assertTrue(m.matches());
    }

    @ParameterizedTest(name = "input = {0}, result = {1}")
    @ValueSource(strings = {"//;\n//;\n1;2;3", "//;\n1;2;3"})
    @DisplayName("Matcher의 find()는 일치하는 부분이 있다면 true를 return 한다.")
    void matcher_find(String input) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        assertTrue(m.find());
    }
}
