package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void spilt_test() {
        String rawString = "1 + 1";
        String[] seperateString = rawString.split(" ");
        System.out.println(seperateString.length);
        System.out.println(Arrays.toString(seperateString));
    }

    @Test
    void 단순_더하기() {
        String str = "1 + 1";
        Calculator calculator = new Calculator();
        calculator.calculator(str);
        assertThat(calculator.calculator(str)).isEqualTo(2);
    }
}
