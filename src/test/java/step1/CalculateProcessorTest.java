package step1;

import org.junit.jupiter.api.Test;
import step1.controller.CalculateProcessor;

import static org.assertj.core.api.Assertions.*;

public class CalculateProcessorTest {
    @Test
    void calculate() {
        CalculateProcessor calculator = new CalculateProcessor();
        assertThat(calculator.calculate(Inputs.createWithoutDelimiter("1,2:3"))).isEqualTo(new InputNumber(6));
        assertThat(calculator.calculate(Inputs.createWithDelimiter("//;\\n1;2;3"))).isEqualTo(new InputNumber(6));
    }
}
