package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AddTwoNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "5:8:13"}, delimiter = ':')
    void addNumbersTest(int num1, int num2, int expected) {
        assertThat(new AddTwoNumbers(num1,num2).calculateTwoNumbers()).isEqualTo(expected);
    }
}