package calculate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    public void constructor() throws Exception {
        //given
        Calculator calculator1 = new Calculator("1:2:3", ":");
        Calculator calculator2 = new Calculator("1:2:3", ":");

        //then
        assertThat(calculator1.equals(calculator2));
    }

    @DisplayName("덧셈 연산")
    @ParameterizedTest
    @CsvSource(value = {"1,1:,:2", "3,3:,:6", "2,3:,:5"}, delimiter = ':')
    public void calculate(String input, String delimiter, int expect) throws Exception {
        //given
        Calculator calculator = new Calculator(input, delimiter);

        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(expect);
    }
}
