package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void addCalculate(){
        int calculate = StringCalculator.calculate("11 + 4");
        assertThat(calculate).isEqualTo(15);
    }

    @Test
    void minusCalculate(){
        int calculate = StringCalculator.calculate("11 - 4");
        assertThat(calculate).isEqualTo(7);
    }

    @Test
    void multiplyCalculate(){
        int calculate = StringCalculator.calculate("11 * 4");
        assertThat(calculate).isEqualTo(44);
    }

    @Test
    void divideCalculate(){
        int calculate = StringCalculator.calculate("11 / 4");
        assertThat(calculate).isEqualTo(2);
    }

    @Test
    void complexCalculate(){
        int calculate = StringCalculator.calculate("11 + 3 - 4 / 5");
        int calculate2 = StringCalculator.calculate("2 + 5 / 7");
        int calculate3 = StringCalculator.calculate("5 - 2 * 10");

        Assertions.assertAll(
                () -> assertThat(calculate).isEqualTo(2),
                () -> assertThat(calculate2).isEqualTo(1),
                () -> assertThat(calculate3).isEqualTo(30)
        );
    }
}
