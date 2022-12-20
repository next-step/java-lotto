package step1;

import step1.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {

    @Test
    @DisplayName("더하기 테스트")
    void addTest() {
        Calculator calculator = new Calculator(3);
        calculator.add(1);
        int result = calculator.getResult();
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minusTest() {
        Calculator calculator = new Calculator(3);
        calculator.minus(2);
        int result = calculator.getResult();
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multipleTest() {
        Calculator calculator = new Calculator(3);
        calculator.multiple(2);
        int result = calculator.getResult();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest() {
        Calculator calculator = new Calculator(3);
        calculator.divide(2);
        int result = calculator.getResult();
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("전체 계산 테스트")
    void calculateTest() {
        String[] input = new String[] {"1", "+", "2", "*", "3"};

        Calculator calculator = new Calculator(input);
        calculator.calculateAll();
        int result = calculator.getResult();
        assertThat(result).isEqualTo(9);
    }

}
