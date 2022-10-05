package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATest {

    @Test
    void adf() {
        String firstNumber = "1";
        String secondNumber = "2";
        int expected = 3;


        Assertions.assertThat(Calculator.add(firstNumber, secondNumber)).isEqualTo(expected);
    }
}
