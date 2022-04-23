package Calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("계산기 통합 테스트")
    public void calcTest() {
        assertEquals(Calculator.executeCalc("1 + 2 + 3 + 4 + 5"), 15);
        assertEquals(Calculator.executeCalc("1 / 2 / 3 / 4 / 5"), 0);
        assertEquals(Calculator.executeCalc("1 * 100 - 100 + 100 / 100"), 1);
        assertEquals(Calculator.executeCalc("100 - 50 + 50 * 2"), 200);
    }
}
