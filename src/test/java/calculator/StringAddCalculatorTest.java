package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("Input이 empty일 경우 0을 반환한다.")
    void empty() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("input이 null일 경우 0을 반환한다.")
    void nullTest(){
        int result = StringAddCalculator.calculate(null);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 0})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void oneNumber(int input){
        int result = StringAddCalculator.calculate(String.valueOf(input));
        assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1,-2", "1,2,-3"})
    @DisplayName("음수를 입력할 경우 RuntimeException 이 발생해야 한다.")
    void minusInput(String input){
        assertThatThrownBy(() -> StringAddCalculator.calculate(input)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3;6", "4,5,6;15", "7,8,9;24"}, delimiter = ';')
    @DisplayName("','구분자로 숫자만 열거되어있는 경우 덧셈을 수행한다.")
    void comma(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(
            value = {"1:2:3;6", "4:5:6;15", "7:8:9;24"}, delimiter = ';'
    )
    @DisplayName("':' 구분자로 숫자만 열거되어있는 경우 덧셈을 수행한다.")
    void colon(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(
            value = {"1:2,3,4;10", "4,5:6;15", "7,8:9;24"}, delimiter = ';'
    )
    @DisplayName("',' ':' 구분자가 혼합되어있을 경우 덧셈 결과를 리턴한다.")
    void mixed(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("'*' 구분자로 열거되어있는 경우 덧셈 결과를 리턴한다.")
    void customDelimiter() {
        String input = "//;\n1;2;3";
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

}