import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @Test
    void createNonNumberValue() {
        assertThrows(NumberFormatException.class, () -> new Number(";"));
    }

    @Test
    void createNegativeValue() {
        assertThrows(NumberFormatException.class, () -> new Number("-1"));
    }
}