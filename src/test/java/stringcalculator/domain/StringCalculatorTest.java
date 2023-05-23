package stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @Test
    void name() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 2", "2 + +", "+ 2 +", "1 + 1 +", " 2 ) 1"})
    void equationErrorTest(String equation) {
        Assertions.assertThatThrownBy(() -> StringCalculator.of(equation)).isInstanceOf(IllegalArgumentException.class);
    }
}
