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
    @MethodSource("parameterOfIsValidLengthArrayTest")
    @DisplayName("isValidLengthArray(): 배열의 크기가 length와 동일하지 않은 경우 false를 그렇지 않은 경우 true를 반환한다.")
    void testIsValidLengthArray(String[] stringArray, int length, boolean expected) {
        assertThat(Validator.isValidLengthArray(stringArray, length)).isEqualTo(expected);
    }

    private static Stream<Arguments> parameterOfIsValidLengthArrayTest() {
        return Stream.of(
                Arguments.of(new String[]{"1", "+", "2"}, 3, true),
                Arguments.of(new String[]{"101.1", "-", "3.1"}, 1, false)
        );
    }
}