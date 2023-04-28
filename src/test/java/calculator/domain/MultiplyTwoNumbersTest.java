package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MultiplyTwoNumbersTest {

    @ParameterizedTest(name = "두 수의 곱를 반환한다 {0} * {1} = {2} ")
    @CsvSource(value = {"5:2:10", "5:4:20"}, delimiter = ':')
    void addNumbersTest(int num1, int num2, int expected) {
        assertThat(new MultiplyTwoNumbers().calculateTwoNumbers(num1,num2)).isEqualTo(expected);
    }
}