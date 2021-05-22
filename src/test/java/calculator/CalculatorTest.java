package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"5,10/15/,", "0:10/10/:", "0:0/0/:"}, delimiter = '/')
    @DisplayName("입력받은 숫자들과 구분자를 분리하여 합을 구한다.")
    void sum_test(String input, int expectedAnswer, String delimiter) {

        //given
        Calculator calculator = new Calculator(input, delimiter);

        //when
        int sum = calculator.sumOperands();

        //then
        assertThat(sum).isEqualTo(expectedAnswer);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,b/,", "a:c/:", ",:0/:", "-1,10/,", "10,-5/,"}, delimiter = '/')
    @DisplayName("구분자를 제외한 값들이 숫자가 아니거나 음수인경우 예외처리한다.")
    void validateOperands_test(String input, String delimiter) {
        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(input, delimiter));
    }
}
