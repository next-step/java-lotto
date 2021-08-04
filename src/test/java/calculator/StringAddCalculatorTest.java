package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기")
class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 입력시 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyAndNullReturnZeroTest(String input) {
        int actual = StringAddCalculator.exec(input);
        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @ParameterizedTest
    @CsvSource(value = {"1=1", "5=5", "9=9"}, delimiter = '=')
    void singleStringReturnInteger(String input, int expected) {
        int actual = StringAddCalculator.exec(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "3,5=8", "2,7=9", "2,8=10"}, delimiter = '=')
    void doubleStringWithCommaReturnSumTest(String input, int expected) {
        int actual = StringAddCalculator.exec(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("컴마, 콜론으로 구분해서 숫자들의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"3,5:1=9", "8,10:2=20", "1,2:3,4=10", "1,1:2,3:3=10"}, delimiter = '=')
    void separatorCommaAndColonSumTest(String input, int expected) {
        int actual = StringAddCalculator.exec(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("// 와 \n 사이에 커스텀 구분자로 구분해서 숫자들의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"'//;\n1;2;3'=6", "'//_\n5_4_1'=10", "'//n\n3n3n3'=9"}, delimiter = '=')
    void customSeparatorSumTest(String input, int expected) {
        int actual = StringAddCalculator.exec(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("음수 입력시 RuntimeException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,-2,-3"})
    void negativeInputRuntimeExceptionTest(String input) {

        assertThatThrownBy(() -> StringAddCalculator.exec(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("input negative numbers");
    }
}