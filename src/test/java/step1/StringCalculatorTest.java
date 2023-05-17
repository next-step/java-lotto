package step1;

import org.junit.jupiter.api.Test;
import step1.CalculateStratety.*;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    String ex = "2 + 3 * 4 / 2";
    StringCalculator calculator = new StringCalculator();
    Formula formula = new Formula(ex);

    @Test
    void 계산() {
        assertThat(calculator.calculate(formula)).isEqualTo(10);
    }
    @Test
    void 더하기() {
        CalculateStrategy cs = new Plus();
        assertThat(cs.go(1,2)).isEqualTo(3);
    }
    @Test
    void 빼기() {
        CalculateStrategy cs = new Minus();
        assertThat(cs.go(3,2)).isEqualTo(1);
    }

    @Test
    void 곱하기() {
        CalculateStrategy cs = new Multi();
        assertThat(cs.go(2,2)).isEqualTo(4);
    }

    @Test
    void 나누기() {
        CalculateStrategy cs = new Divide();
        assertThat(cs.go(4,2)).isEqualTo(2);
    }

}
