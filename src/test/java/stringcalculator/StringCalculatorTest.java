package stringcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        StringInputParser stringInputParser = new StringInputParser();
        stringCalculator = new StringCalculator(stringInputParser);
    }

    @Test
    void Given_string_When_calculate_Then_succeed() {
        // given
        String input = "1 + 2 - 3 + 4 * 5 / 2";

        // when
        String result = stringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo("10");
    }

    @Test
    void Test_add() {
        // given
        String validA = "1", validB = "2";

        // when
        Long added = stringCalculator.add(validA, validB);

        // then
        assertThat(added).isEqualTo(3L);
    }

    @Test
    void Test_subtract() {
        // given
        String validA = "1", validB = "0";

        // when
        Long result = stringCalculator.subtract(validA, validB);

        // then
        assertThat(result).isEqualTo(1L);
    }

    @Test
    void Test_multiply() {
        // given
        String validA = "1", validB = "2";

        // when
        Long result = stringCalculator.multiply(validA, validB);

        // then
        assertThat(result).isEqualTo(2L);
    }

    @Test
    void Test_divide() {
        // given
        String validA = "1", validB = "2";

        // when
        Long result = stringCalculator.divide(validA, validB);

        // then
        assertThat(result).isEqualTo(0L);
    }

}