package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static stringcalculator.Operator.*;

public class OperatorTest {

    @DisplayName("덧셈 테스트")
    @Test
    void operateSum() {
        int sumNumber = SUM.calculateNumbers(1, 2);
        assertThat(sumNumber).isEqualTo(3);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void operateSub() {
        int subNumber = SUBTRACTION.calculateNumbers(10, 8);
        assertThat(subNumber).isEqualTo(2);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void operateMul() {
        int mulNumber = MULTIPLICATION.calculateNumbers(5, 9);
        assertThat(mulNumber).isEqualTo(45);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void operateDiv() {
        int divNumber = DIVISION.calculateNumbers(8, 3);
        assertThat(divNumber).isEqualTo(2);
    }

    @DisplayName("잘못된 연산자 테스트")
    @Test
    void errorOperator() {
        Calculator calculator = new Calculator();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.calculatorSystem("1@2"));
    }
}
