package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;


    @Test
    void 덧셈() {
        Integer result1 = StringCalculator.calculate("2 + 3");

        Assertions.assertThat(result1).isEqualTo(5);


        Integer result2 = StringCalculator.calculate("4 + 3 + 2 + 1");

        Assertions.assertThat(result2).isEqualTo(10);
    }
}
