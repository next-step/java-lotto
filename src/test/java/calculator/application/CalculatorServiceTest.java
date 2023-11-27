package calculator.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();
    @Test
    void calculateTest() {
        double result = calculatorService.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10.00);
    }

    @Test
    void calculateFailTest() {
        Assertions.assertThrows(NumberFormatException.class,
                                () -> calculatorService.calculate("2  ++"));
    }
}
