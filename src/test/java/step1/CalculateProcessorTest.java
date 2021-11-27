package step1;

import org.junit.jupiter.api.Test;
import step1.controller.CalculateProcessor;
import step1.domain.Number;
import step1.domain.Inputs;

import static org.assertj.core.api.Assertions.*;

public class CalculateProcessorTest {
    @Test
    void calculate() {
        CalculateProcessor calculator = new CalculateProcessor();
        assertThat(calculator.calculate(Inputs.createWithoutDelimiters("1,2:3"))).isEqualTo(new Number(6));
        assertThat(calculator.calculate(Inputs.createWithDelimiters("//;\\n1;2;3"))).isEqualTo(new Number(6));
    }
}
