package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorServiceTest {

    private StringCalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new StringCalculatorService();
    }

    @Test
    void 계산기_정상_실행() {
        int actual = calculatorService.calculateExpressions("2 + 3 * 4 / 2");

        assertEquals(10, actual);
    }

}
