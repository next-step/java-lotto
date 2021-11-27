package calculator;

import calculator.exception.NumberConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @DisplayName("StringAddCalculator의 매개변수로 null 또는 빈문자열을 입력한 경우 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(0);
    }

    @DisplayName("StringAddCalculator의 매개변수로 숫자 하나만 입력한 경우 숫자 그대로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "3, 3", "4, 4"})
    void splitAndSum_숫자하나(String text, int expectedResult) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(expectedResult);
    }

    @DisplayName("StringAddCalculator의 매개변수로 쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2/3", "2,3,4/9", "3,3/6", "4,4,2/10"}, delimiter = '/')
    void splitAndSum_쉼표구분자(String text, int expectedResult) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(expectedResult);
    }

    @DisplayName("StringAddCalculator의 매개변수로 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3/6", "2:3,4/9", "3:3/6", "4:4:2/10"}, delimiter = '/')
    void splitAndSum_쉼표_또는_콜론_구분자(String text, int expectedResult) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(expectedResult);
    }

    @DisplayName("앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//@\n2@2@2", "//#\n1#1#2#2"})
    void splitAndSum_custom_구분자(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(6);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 NumberConstraintViolationException 예외를 throw한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,1,@", "3,#,2"})
    void splitAndSum_negative(String text) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(NumberConstraintViolationException.class);
    }
}
