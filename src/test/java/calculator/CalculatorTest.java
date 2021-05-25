package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"5,10|15", "0:10|10", "0:0|0", "5,3:10|18"}, delimiter = '|')
    @DisplayName("입력받은 숫자들과 구분자를 분리하여 합을 구한다.")
    void sum_test(String input, int expectedAnswer) {
        //given
        Calculator calculator = new Calculator(input);

        //when
        int sum = calculator.sumOperands();

        //then
        assertThat(sum).isEqualTo(expectedAnswer);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,b", "a:c", ",:0", "-1,10", "10,-5"}, delimiter = '/')
    @DisplayName("구분자를 제외한 값들이 숫자가 아니거나 음수인경우 예외처리한다.")
    void validateOperands_test(String input) {
        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(input));
    }

    @Test
    @DisplayName("입력 값이 공백인 경우 0을 리턴한다.")
    void emptyNullInput_test() {
        //when
        Calculator calculator = new Calculator("");

        assertThat(calculator.sumOperands()).isEqualTo(0);
    }

    @Test
    @DisplayName("입력 값이 null인 경우 0을 리턴한다.")
    void nullInput_test() {
        //when
        Calculator calculator = new Calculator(null);

        assertThat(calculator.sumOperands()).isEqualTo(0);
    }


    @Test
    @DisplayName("앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.")
    void sumByCustomDelimiter_test() {
        //given
        Calculator calculator = new Calculator("//;\n1;2;3");

        //when
        int sum = calculator.sumOperands();

        //then
        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource({"5]10", "10<20", "20'30"})
    @DisplayName("커스텀 구분자가 아닌경우 기본 구분자를 입력하지 않았을 때 에외처리한다.")
    void wrongDefaultDelimiter_test(String input) {
        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(input));
    }
}
