package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void InitTest() {
        new StringCalculator(List.of("1", "+", "22", "-", "333", "*", "4444", "/", "55555"));
    }

    @Test
    void calculateAddTest() {
        StringCalculator calculator = new StringCalculator(List.of("2", "+", "3"));
        assertThat(calculator.calculate()).isEqualTo(5);
    }

    @Test
    void calculateSubtractTest() {
        StringCalculator calculator = new StringCalculator(List.of("2", "-", "3"));
        assertThat(calculator.calculate()).isEqualTo(-1);
    }

    @Test
    void calculateMultiPlyTest() {
        StringCalculator calculator = new StringCalculator(List.of("2", "*", "3"));
        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    void calculateTest() {
        StringCalculator calculator = new StringCalculator(
            List.of("2", "+", "3", "*", "4", "/", "2"));
        assertThat(calculator.calculate()).isEqualTo(10);
    }

    @Test
    void calculateDivideTest() {
        StringCalculator calculator = new StringCalculator(List.of("6", "/", "3"));
        assertThat(calculator.calculate()).isEqualTo(2);
    }

}
