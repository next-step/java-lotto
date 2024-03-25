package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("isNonBlank(): NUll 또는 '' 또는 '   '인 경우 false를 반환한다.")
    void testIsNonBlank(String string) {
        assertThat(Validator.isNonBlank(string)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "10:true", "14000:true", "abc:false", "1.1:false", "NULL:false", "'':false", "'   ':false", "-1:false", "0:false", "0123:false"}, delimiter = ':', nullValues = "NULL")
    @DisplayName("isPositiveInteger(): 양의 정수인 경우 true를 그렇지 않은 경우 false를 반환한다.")
    void testIsPositiveInteger(String numberString, boolean expected) {
        assertThat(Validator.isPositiveInteger(numberString)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:true", "10:true", "14000:true", "abc:false", "1.1:false", "NULL:false", "'':false", "'   ':false", "-1:false",  "0123:false"}, delimiter = ':', nullValues = "NULL")
    @DisplayName("isIntegerGreaterThanOrEqualToZero(): 0보다 크거가 같은 정수인 경우 true를 그렇지 않은 경우 false를 반환한다.")
    void testIsIntegerGreaterThanOrEqualToZero(String numberString, boolean expected) {
        assertThat(Validator.isIntegerGreaterThanOrEqualToZero(numberString)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterOfIsEqualToLengthTest")
    @DisplayName("isEqualToLength(): stringArray의 길이가 length와 동일한 경우 true를 그렇지 않은 경우 false를 반환한다.")
    void testIsEqualToLength(String[] stringArray, int length, boolean expected) {
        assertThat(Validator.isEqualToLength(stringArray, length)).isEqualTo(expected);
    }

    private static Stream<Arguments> parameterOfIsEqualToLengthTest() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3"}, 3, true),
                Arguments.of(new String[]{"1", "2", "2", "4", "5", "6"}, 6, true),
                Arguments.of(new String[]{"1", "2"}, 3, false)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:10:true", "22:1:43:true", "44:1:43:false", "50:1:43:false"}, delimiter = ':')
    @DisplayName("isInRange(): min <= number <= max인 경우 true를 그렇지 않은 경우 false를 반환한다.")
    void testIsInRange(int number, int minimum, int maximum, boolean expected) {
        assertThat(Validator.isInRange(number, minimum, maximum)).isEqualTo(expected);
    }
}
