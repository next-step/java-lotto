package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈")
    void addition(){
        assertThat(Calculator.addition(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void subtraction(){
        assertThat(Calculator.subtraction(4,3)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈")
    void multiplication(){
        assertThat(Calculator.multiplication(4,3)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈")
    void division(){
        assertThat(Calculator.division(13,4)).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:+:3", "4:3:-:1", "4:3:*:12", "13:4:/:3"}, delimiter = ':')
    @DisplayName("사칙연산 기호에 따라 다른 결과값을 출력한다.")
    void containsCsvSource(int number, int number2, String symbol, int expected) {
        assertThat(Calculator.calculate(symbol, number, number2)).isEqualTo(expected);
    }

}
