package stringCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperatorFactoryTest {

    @Test
    void testValidOperators() {
        assertInstanceOf(PlusCalculator.class, OperatorFactory.getCalculator("+"));
        assertInstanceOf(SubtractionCalculator.class, OperatorFactory.getCalculator("-"));
        assertInstanceOf(MultipleCalculator.class, OperatorFactory.getCalculator("*"));
        assertInstanceOf(DivisionCalculator.class, OperatorFactory.getCalculator("/"));
    }

    @Test
    void testInvalidOperatorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> OperatorFactory.getCalculator("%"));
    }
}
