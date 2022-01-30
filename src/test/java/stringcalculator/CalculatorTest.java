package stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class CalculatorTest {


    @Test
    public void 숫자리스트_계산_테스트(){
        List<String> numbers = Arrays.asList("1", "2", "3");
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator.calculate(numbers)).isEqualTo(6);


    }

}
