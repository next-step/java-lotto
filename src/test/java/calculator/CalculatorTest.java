package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void empty(String input) {

        int result = Calculator.process(input);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "0"})
    void single(String input) {

        int result = Calculator.process(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
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

    @Test
    void customDelimiters() {

        int result = Calculator.process("//;\\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "word"})
    void containsWord(String input) {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator.process(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    void containsNegative(String input) {

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
