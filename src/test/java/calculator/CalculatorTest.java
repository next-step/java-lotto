package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ValueSource(strings = {"//;\n1;2;3", "1:2:3", "3,2,1"})
    @ParameterizedTest(name = "[{argumentsWithNames}] 문자열 덧셈계산기가 잘 동작한다.")
    void name(String input) {
        CalNumbers calNumbers = CalNumbers.create(input, new StringSplitter());

        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(calNumbers)).isEqualTo(6);
    }

    @NullAndEmptySource
    @ParameterizedTest(name = "[{argumentsWithNames}] 값이 오는경우, 합은 0이다.")
    void emptyTest(String input) {
        CalNumbers calNumbers = CalNumbers.create(input, new StringSplitter());

        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(calNumbers)).isEqualTo(0);
    }
}
