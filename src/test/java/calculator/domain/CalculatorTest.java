package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void calculate_null_또는_빈문자() {
        int result = Calculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculate_쉼표구분자() {
        int result = Calculator.calculate("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void calculate_쉼표_또는_콜론_구분자() {
        int result = Calculator.calculate("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculate_custom_구분자() {
        int result = Calculator.calculate("//;\\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculate_negative() {
        assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Cannot be less than 0");
    }
}
