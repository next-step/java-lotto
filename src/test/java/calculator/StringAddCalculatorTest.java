package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    private final StringAddCalculator calculator = new StringAddCalculator();

    @ParameterizedTest(name = "쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @CsvSource(value = {"1,2:3=6", "1,2=3", "1:2=3", "1=1"}, delimiter = '=')
    public void addByDefaultDelimiterTest(String input, int expectedResult) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용 할 수 있다.")
    @CsvSource(value = {"//;\\n1;2;3=6", "//+\\n1+2=3"}, delimiter = '=')
    public void addByCustomDelimiterTest(String input, int expectedResult) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult);
    }

}