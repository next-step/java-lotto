package step2;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @DisplayName("빈 문자열 또는 null을 입력하는 경우 0을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void emptyStringTest(String text) {
        assertEquals(0, calculator.execute(text));
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @MethodSource("singleStringTestCase")
    @ParameterizedTest
    void singleStringTest(String text, int expected) {
        int actual = calculator.execute(text);
        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> singleStringTestCase() {
        return Stream.iterate(0, i -> i + 1)
                     .limit(10)
                     .map(i -> Arguments.of(String.valueOf(i), i));
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @CsvSource(value = {"1,2:3", "3,5:8", "5,9:14"}, delimiter = ':')
    @ParameterizedTest
    void twoNumberSumTest(String text, int expected) {
        int actual = calculator.execute(text);
        assertEquals(expected, actual);
    }

    @DisplayName("컴마 외에 콜론(:)을 구분자로 사용하여 구분할 수 있다.")
    @CsvSource(value = {"1:2,3", "3:5,8", "5:9,14"}, delimiter = ',')
    @ParameterizedTest
    void colonDelimiterTest(String text, int expected) {
        int actual = calculator.execute(text);
        assertEquals(expected, actual);
    }

    @DisplayName("`//`와 `\\n` 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : //;\\n1;2;3 => 6)")
    @MethodSource("customDelimiterTestCase")
    @ParameterizedTest
    void customDelimiterTest(String text, int expected) {
        int actual = calculator.execute(text);
        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> customDelimiterTestCase() {
        return Stream.of(
            Arguments.of("//;\\n1;2;3", 6),
            Arguments.of("//~\\n1~2,3", 6),
            Arguments.of("//!\\n1!2:3", 6)
        );
    }

    @DisplayName("음수가 포함된 경우 예외가 발생한다.")
    @ValueSource(strings = {"-1,2,3", "3:-5,8", "5:9,-14"})
    @ParameterizedTest
    void negativeNumberTest(String text) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> calculator.execute(text))
            .withMessage("양의 정수만 입력해주세요.");
    }
}