package StringAddCalculatorTest;

import stringaddcalculator.StringAddCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringAdderTest {
    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void initStringAddCalculator() {
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "1,2,3:6"}, delimiter = ':')
    void Given_Inputs_When_Calculate_Then_AddedNumber(String input, int expected) {
        //when
        int actual = stringAddCalculator.calculate(input);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void Given_InputWithCustomDelimiter_When_Calculate_Then_AddedNumber() {
        //given
        String input = "//,\n1,2";

        //when
        int actual = stringAddCalculator.calculate(input);

        //then
        assertThat(actual).isEqualTo(3);
    }
}
