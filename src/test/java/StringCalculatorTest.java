import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @Test
    void blank() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(" ");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "%", "&", "^"})
    void single_unknownOperator(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"! !", "% %", "& & &", "^ ^ ^ ^"})
    void multiple_unknownOperator(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ! 2", "2 % 3", "3 & 4", "4 ^ 5"})
    void containsUnknownOperators(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void single_knownOperator(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+ /", "- + *", "* - + /"})
    void multiple_knownOperator(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5", "-1", "0", "1", "5", "10"})
    void single_operand(final String input) {
        assertThat(StringCalculator.compute(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5 -1", "-1 0", "0 1", "1 5", "5 10"})
    void double_operands(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 2 2", "4 2 / 2", "1 + 3 5 7 / 9", "1 3 5 * 7 + 9"})
    void notMatched_operands_operators(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.compute(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"-5 + -1:-6", "-1 * 0:0", "4 / 2:2", "1 + 5 + 7:13",
        "5 + 10 * 20 / 100:3"}, delimiter = ':')
    void matched_operands_operators(final String input, final int answer) {
        assertThat(StringCalculator.compute(input)).isEqualTo(answer);
    }


}
