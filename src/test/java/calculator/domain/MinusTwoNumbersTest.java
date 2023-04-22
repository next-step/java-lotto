package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MinusTwoNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {"5:2:3", "26:13:13"}, delimiter = ':')
    void addNumbersTest(int num1, int num2, int expected) {
        assertThat(new MinusTwoNumbers(num1,num2).calculateTwoNumbers()).isEqualTo(expected);
    }

}