import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+=5", "-=1", "*=6", "/=1"}, delimiter = '=')
    @DisplayName("주어진 연산이 제대로 동작하는지에 대한 테스트")
    void doCalculate(String operator, int excepted) {

        Calculator calculator = new Calculator();
        String lastNumberStr = "2";
        String firstNumberStr = "3";

        int result = calculator.calculate(firstNumberStr, operator, lastNumberStr);

        assertEquals(result, excepted);
    }

    @Test
    @DisplayName("사칙연산이 아닌경우 IllegalArgumentException 을 던지는 테스트")
    void notAllowedOperator() {
        Calculator calculator = new Calculator();
        String lastNumberStr = "2";
        String firstNumberStr = "3";
        String operator = "!";

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(lastNumberStr, operator, firstNumberStr));
    }
}