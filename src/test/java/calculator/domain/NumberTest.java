package calculator.domain;

import calculator.exception.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    void sum() {
        Number number1 = new Number("");
        Number number2 = new Number(" ");
        Number number3 = new Number("1");

        assertThat(number1.sum(10)).isEqualTo(10);
        assertThat(number2.sum(10)).isEqualTo(10);
        assertThat(number3.sum(10)).isEqualTo(11);

        assertThatThrownBy(() -> new Number("-1"))
                .isInstanceOf(CalculatorException.class)
                .hasMessageContaining("Cannot be less than 0");
    }
}
