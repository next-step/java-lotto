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
        assertTrue(m.find());
        assertEquals(expected, m.group(TARGET_INDEX));
    }

    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"test", ";", "//?"})
    @DisplayName("Match 실패 케이스")
    void matcher_fail(String input) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        assertFalse(m.find());
        assertThrows(IllegalStateException.class, () -> m.group(TARGET_INDEX));
    }
}
