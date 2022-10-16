package StringCalculator.backend.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    @DisplayName("산식계산")
    @ParameterizedTest(name = "[{index}] {0} = {1}")
    @CsvSource({"1 * 2 / 2 + 3, 4", "3 * 10 / 2 - 1, 14"})
    void calculate(String a, int b) {
        CalculatorController controller = new CalculatorController();
        assertEquals(b, controller.run(a));
    }
}
