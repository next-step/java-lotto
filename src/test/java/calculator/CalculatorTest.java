package calculator;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @ParameterizedTest(name = "입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다. 사칙연산의 우선순위가 아니라 입력 값에 따라 사칙 연산을 한다.")
    @CsvSource(value = {
            "1 + 2 + 3:6",
            "3 - 2 - 2:-1",
            "1 * 2 * 3:6",
            "6 / 2 / 3:1",
            "50 + 40 - 30 * 2 / 12:10"}, delimiter = ':')
    public void calculate(String input, int excepted) {
        int result = Calculator.calculate(input);
        Assertions.assertThat(result).isEqualTo(excepted);
    }
}