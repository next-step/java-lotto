package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void add(){
        Integer sum = StringCalculator.add("11 + 4");
        assertThat(sum).isEqualTo(15);
    }
}
