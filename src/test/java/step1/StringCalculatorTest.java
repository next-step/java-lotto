package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void add(){
        Integer sum = StringCalculator.add("11 + 4");
        assertThat(sum).isEqualTo(15);
    }

    @Test
    void minus(){
        int minus = StringCalculator.minus("11 - 4 - 3");
        assertThat(minus).isEqualTo(4);
    }
}
