package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Matcher 사용법을 확인하기 위한 테스트")
class MatcherTest {

    private static final String TEST_REGEX = "//(.)\n(.*)";
    private static final Pattern TEST_REGEX_PATTERN = Pattern.compile(TEST_REGEX);

    @DisplayName("정규 표현식과 유효한 값의 매칭 여부 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\ncar", "//&\nlacing"})
    void findValidRegexExpressionTest(String input) {
        // When
        Matcher matcher = TEST_REGEX_PATTERN.matcher(input);
        boolean expected = matcher.find();

        // Then
        assertThat(expected).isTrue();
    }

    @DisplayName("정규 표현식과 무효한 값의 매칭 여부 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "car", "lacing"})
    void findInvalidRegexExpressionTest(String input) {
        // When
        Matcher matcher = TEST_REGEX_PATTERN.matcher(input);
        boolean expected = matcher.find();

        // Then
        assertThat(expected).isFalse();
    }

    @DisplayName("()로 감싼 Group 이 추출되는지 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\ncar1990", "//&\ncar1987"})
    void temp(String input) {
        // Given
        String[] expectedGroups = input.replace("//", "").split("\n");
        String expectedFirstGroup = expectedGroups[0];
        String expectedSecondGroup = expectedGroups[1];

        // When
        Matcher matcher = TEST_REGEX_PATTERN.matcher(input);
        matcher.find();
        String actualFirstGroup = matcher.group(1);
        String actualSecondGroup = matcher.group(2);

        // Then
        assertAll(
                () -> assertThat(actualFirstGroup).isEqualTo(expectedFirstGroup),
                () -> assertThat(actualSecondGroup).isEqualTo(expectedSecondGroup)
        );
    }
}
