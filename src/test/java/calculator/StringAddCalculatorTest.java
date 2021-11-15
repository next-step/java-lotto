package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "", " "})
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void emptyOrNullValueReturn0Test(String input){
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "3"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void onlyNumberStringReturnNumber(String input){
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @CsvSource(value = { "1,2;3", "2,3,4;9", "1,3,6;10"}, delimiter = ';')
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void commaSeparatedAddNumbers(String input, int expected){
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1,2:3;6", "1:3,6;10"}, delimiter = ';')
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void colonSeparatedAddNumbers(String input, int expected){
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void customCharSeparatedAddNumbers(){
        int result1 = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result1).isEqualTo(6);
        int result2 = StringAddCalculator.splitAndSum("//;\n1;3;6");
        assertThat(result2).isEqualTo(10);
    }
}