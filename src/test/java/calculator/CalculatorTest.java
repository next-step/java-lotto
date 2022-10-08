package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:3:5", "91:9:100"}, delimiter = ':')
    void 덧셈을_한다(int a, int b, int answer){
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.add(a, b)).isEqualTo(answer);
    }
}
