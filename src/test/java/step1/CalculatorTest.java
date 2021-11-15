package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Calculator;
import step1.domain.Number;
import step1.util.InputUtil;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void calculatorTest() {
        String input = "5,10,100";
        Calculator calculator = new Calculator();
        assertThat(calculator.Add(InputUtil.paresNumberList(input))).isEqualTo(new Number(115));
    }
}
