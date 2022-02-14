package stringcalculator;

import static stringcalculator.domain.Calculator.calculator;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {


    @Test
    public void 숫자리스트_계산_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Assertions.assertThat(calculator.calculate(numbers)).isEqualTo(6);
    }

}
