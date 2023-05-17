package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyOperatorTest {
    static final int DEFAULT_FIRST_ARG = 2;
    static final int DEFAULT_SECOND_ARG = 3;

    @Test
    @DisplayName("곱하기 테스트")
    void multiply() {
        Calculator calculator = Calculator.create(String.format("%d * %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG));
        assertEquals(DEFAULT_FIRST_ARG * DEFAULT_SECOND_ARG, calculator.calculate());
    }
}
