package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"0,0,0", "1,2,3", "3,-4,-1", "-5,6,1", "-7,-8,-15"})
    void add(int addend1, int addend2, int expected) {
        assertThat(Calculator.add(addend1, addend2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0", "1,2,-1", "3,-4,7", "-5,6,-11", "-7,-8,1"})
    void subtract(int minuend, int subtrahend, int expected) {
        assertThat(Calculator.subtract(minuend, subtrahend)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0", "0,1,0", "2,3,6", "4,-5,-20", "-6,7,-42", "-8,-9,72"})
    void multiply(int multiplicand, int multiplier, int expected) {
        assertThat(Calculator.multiply(multiplicand, multiplier)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,1,0", "1,1,1", "4,-2,-2", "-6,2,-3", "-10,-5,2", "17,1,17"})
    void divide(int dividend, int divisor, int expected) {
        assertThat(Calculator.divide(dividend, divisor)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, -5})
    void 제수로_0을_사용할_수_없다(int dividend) {
        assertThatThrownBy(() -> Calculator.divide(dividend, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

}