package calculator;

import org.junit.jupiter.api.Test;
import service.calculator.Calculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 문자열_계산기() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
