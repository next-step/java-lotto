package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void stringAddCalculator() {
        int ans = StringAddCalculator.calculate("1,2:3");
        assertEquals(6, ans);
    }
    
}
