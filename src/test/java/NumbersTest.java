import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void when_strInput_with_delimiters_then_create_numbers() {
        // given
        String input = "2:3,4";
        Number expectedNumber1 = new Number(2);
        Number expectedNumber2 = new Number(3);
        Number expectedNumber3 = new Number(4);

        // when
        Numbers numbers = new Numbers(input);
        Numbers expectedNumbers = new Numbers(expectedNumber1, expectedNumber2, expectedNumber3);

        // then
        assertThat(numbers).isEqualTo(expectedNumbers);
    }


    @Test
    void when_strInput_with_custom_delimiters_then_create_numbers() {
        // given
        String input = "//!\n2!3!4";
        Number expectedNumber1 = new Number(2);
        Number expectedNumber2 = new Number(3);
        Number expectedNumber3 = new Number(4);
        // when
        Numbers numbers = new Numbers(input);
        Numbers expectedNumbers = new Numbers(expectedNumber1, expectedNumber2, expectedNumber3);
        // then
        assertThat(numbers).isEqualTo(expectedNumbers);
    }

    @Test
    void when_plusAllNumbers_then_returns_additions() {
        // given
        Number number1 = new Number(2);
        Number number2 = new Number(3);
        Number number3 = new Number(4);
        Numbers numbers = new Numbers(number1, number2, number3);
        Number expectedResult = new Number(9);

        // when
        Number result = numbers.calculateAddAll();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void when_input_is_emptyString_and_calculateAddition_returns_0() {
        // given
        String input = "    ";
        Numbers numbers = new Numbers(input);
        Number expectedResult = new Number(0);

        // when
        Number result = numbers.calculateAddAll();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void when_input_is_Null_and_calculateAddition_returns_0() {
        // given
        String input = null;
        Numbers numbers = new Numbers(input);
        Number expectedResult = new Number(0);

        // when
        Number result = numbers.calculateAddAll();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}