package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"     "})
    @DisplayName("isNonBlank(): 입력으로 NULL이나 빈 문자열이 주어진 경우 false를 반환한다.")
    void testIsNonBlank(String input) {
        assertThat(Validator.isNonBlank(input)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "0:true", "0.0:true", "-1:true", "-1.1:true", "1.1:true", "NULL:false", "'':false", "'   ':false", "+1:false", "+1.1:false", "+-12.121:false"}, delimiter = ':', nullValues = "NULL")
    @DisplayName("isNumber(): 입력된 값이 숫자인 경우 true를 그렇지 않는 경우 false를 반환한다.")
    void testIsNumber(String input, boolean expected) {
        assertThat(Validator.isNumber(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterOfIsGreaterThanOrEqualToLengthTest")
    @DisplayName("isGreaterThanOrEqualToLength(): 주어진 배열의 크기가 length보다 크거나 같은 경우 true를 그렇지 않으면 false를 반환한다.")
    void testIsGreaterThanOrEqualToLength(String[] stringArray, int length, boolean expected) {
        assertThat(Validator.isGreaterThanOrEqualToLength(stringArray, length)).isEqualTo(expected);
    }

    private static Stream<Arguments> parameterOfIsGreaterThanOrEqualToLengthTest() {
        return Stream.of(
                Arguments.of(new String[]{"1", "+", "2"}, 3, true),
                Arguments.of(new String[]{"1", "+", "2", "*", "10"}, 3, true),
                Arguments.of(new String[]{"101.1", "-"}, 3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterOfIsOddNumberLengthTest")
    @DisplayName("isOddNumberLength(): 주어진 배열의 크기가 홀수면 true 그렇지 않으면 false를 반환한다.")
    void testIsOddNumberLength(String[] stringArray, boolean expected) {
        assertThat(Validator.isOddNumberLength(stringArray)).isEqualTo(expected);
    }

    private static Stream<Arguments> parameterOfIsOddNumberLengthTest() {
        return Stream.of(
                Arguments.of(new String[]{"1", "+", "2"}, true),
                Arguments.of(new String[]{"1", "+", "2", "*", "10"}, true),
                Arguments.of(new String[]{"101.1", "-"}, false)
        );
    }
}
