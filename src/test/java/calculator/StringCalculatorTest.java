package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void add(){
        int result = StringCalculator.add(1,3);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void subtract(){
        int result = StringCalculator.subtract(5,3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply(){
        int result = StringCalculator.multiply(5,3);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void divide(){
        int result = StringCalculator.divide(10,2);

        assertThat(result).isEqualTo(5);
    }
}
