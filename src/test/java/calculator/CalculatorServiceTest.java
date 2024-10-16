package calculator;

import org.junit.jupiter.api.Test;
import calculator.service.CalculatorService;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {

    @Test
    public void 문자열_계산기() {
        assertThat(CalculatorService.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
