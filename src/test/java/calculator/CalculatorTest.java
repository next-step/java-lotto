package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @CsvSource(value = {
            "2 + 3,5",
            "2 + 3 - 1,4",
            "2 + 3 - 1 * 3,12",
            "2 + 3 - 1 * 3 / 12,1",
    })
    @DisplayName("문자열 입력값을 계산하여 결과를 반환한다.")
    @ParameterizedTest(name = "{0} = {1}")
    void test01(String input, int expected) {
        int actual = Calculator.calculate(input);
        assertThat(actual).isSameAs(expected);
    }
}