package stringCalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void calculate() {
        Assertions.assertThat(StringCalculator.from("1,2:3").calculate())
                .isEqualTo(6);
        Assertions.assertThat(StringCalculator.from("").calculate())
                .isEqualTo(0);
        Assertions.assertThat(StringCalculator.from(",1,,1,").calculate())
                .isEqualTo(2);
    }
}