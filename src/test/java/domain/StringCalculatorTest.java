package domain;

import calculator.domain.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void 계산() {
        StringCalculator stringCalculator = new StringCalculator(new String[]{"2", "+", "3", "*", "4", "/", "2"});

        Assertions.assertThat(stringCalculator.calculate()).isEqualTo(10);
    }
}
