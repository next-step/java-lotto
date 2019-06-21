package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    @Test
    void empty() {

        int result = Calculator.process("");
        assertThat(result).isZero();
    }

    @Test
    void single() {

        int result = Calculator.process("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void doubles() {

        int result = Calculator.process("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    void triple() {

        int result = Calculator.process("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void commaAndColon() {

        int result = Calculator.process("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "word", "-1"})
    void wordOrNegative(String input) {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator.process(input));
    }

    @Test
    void commaWithNegative() {

        String input = "1,-12";
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator.process(input));
    }
}
