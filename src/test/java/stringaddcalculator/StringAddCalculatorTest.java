package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @DisplayName("숫자 이외의 값이 입력되면 예외를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,@,3", "10,2,3:=", "%,),2:*"})
    void convertToNumberTest(String input) {
        //when, then
        assertThatThrownBy(() -> {
            StringAddCalculator.addString(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음수를 입력하면 예외를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,-1,0", "10,-9", "20,-20,-1"})
    void validateNegativeTest(String input) {
        //when, then
        assertThatThrownBy(() -> {
            StringAddCalculator.addString(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("null 또는 공백 문자열이 입력되면 0을 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void addStringTestWhenNullOrEmpty(String input) {
        //when
        int sum = StringAddCalculator.addString(input);

        //then
        assertThat(sum).isZero();
    }

    @DisplayName("제대로 숫자를 입력하면, 합(sum)을 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,2,4=6", "7,3,1,23,5=39", "1,2:5,34:3=45"}, delimiter = '=')
    void sumTest(String input, int expected) {
        //given
        int sum = StringAddCalculator.addString(input);

        //then
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 입력하면, 합(sum)을 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;@1;2;3", "//@@1@2@3", "//#@1#2#3"})
    void splitByCustomTest(String input) {
        //when
        int sum = StringAddCalculator.addString(input);

        //then
        assertThat(sum).isEqualTo(6);
    }
}