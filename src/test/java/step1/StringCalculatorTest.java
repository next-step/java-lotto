package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void add(){
        int sum = StringCalculator.add("11 + 4");
        assertThat(sum).isEqualTo(15);
    }

    @Test
    void minus(){
        int minus = StringCalculator.minus("11 - 4 - 3");
        assertThat(minus).isEqualTo(4);
    }

    @Test
    void multiply(){
        int multiply = StringCalculator.multiply("11 * 5");
        assertThat(multiply).isEqualTo(55);
    }

    @Test
    void divide(){
        int divide = StringCalculator.divide("10 / 5");
        assertThat(divide).isEqualTo(2);
    }
}
