package calculators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("기본 구분자 입력받아 합 반환하기")
    void basic_separator() {
        final String input = "1,2:3";

        Calculator c = new Calculator();
        int sum = c.calculate(input);

        assertEquals(sum, 6);
    }
}
