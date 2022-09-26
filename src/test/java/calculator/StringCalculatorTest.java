 package calculator;

import calculator.type.Divide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

 public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();;

    @ParameterizedTest
    @CsvSource(value = {"1=1",
                        "5 * 2=10",
                        "2 + 3 * 4 / 2=10",
                        "5 / 2 + 10 * 2 - 10=14"},
            delimiter = '=')
    void calculate(String input, int expected) {
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("0으로 나누면 예외 발생")
    @Test
    void divideZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Divide().operate(10, 0));
    }

    @DisplayName("지원하지 않는 연산자 입력 시 예외 발생")
    @Test
    void calculateWhenInputNotSupportedOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("2 % 3"));
    }
}
