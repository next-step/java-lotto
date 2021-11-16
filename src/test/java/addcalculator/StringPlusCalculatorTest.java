package addcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringPlusCalculatorTest {

    @DisplayName("입력된 값이 null 혹은 공백일 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void returnZeroFormEmptyAndNull(String input)  {
        assertThat(StringPlusCalculator.execute(input)).isEqualTo(0);
    }

    @DisplayName("콤마로 분리된 숫자를 계산한다")
    @ParameterizedTest(name = "{0}이 입력될때 결과값 {1}")
    @CsvSource(value = {
            "'2,5,2,3' | 12",
            "'6,3' | 9"
    }, delimiter = '|')
    void plusFromComa(String input, int expected) {
        assertThat(StringPlusCalculator.execute(input)).isEqualTo(expected);
    }

    @DisplayName("콤마 또는 콜론으로 분리된 숫자를 계산한다")
    @ParameterizedTest(name = "{0}이 입력될때 결과값 {1}")
    @CsvSource(value = {
            "'4:2,5:7,2' | 20",
            "'4:5:2,3' | 14"
    }, delimiter = '|')
    void plusFromCommaAndColon(String input, int expected) {
        assertThat(StringPlusCalculator.execute(input)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자가 있을경우 숫자를 계산한다")
    @ParameterizedTest(name = "{0}이 입력될때 결과값 {1}")
    @CsvSource(value = {
            "'//;\n1;2;3' | 6",
            "'//@\n1@4@6' | 11"
    }, delimiter = '|')
    void plusFromCustomSeparator(String input, int expected) {
        assertThat(StringPlusCalculator.execute(input)).isEqualTo(expected);
    }

}