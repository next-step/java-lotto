package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    @Test
    @DisplayName("인자로 넘긴 값들로 사칙연산을 수행하여 합산된 값을 반환한다.")
    void 사칙연산_수행() {
        List<Integer> operandList = Arrays.asList(2, 3, 8, 2);
        List<String> operatorList = Arrays.asList("+", "*", "/");

        Calculator calculator = new Calculator(operandList, operatorList);
        int result = calculator.calculate();

        Assertions.assertThat(result).isEqualTo(20);
    }

}
