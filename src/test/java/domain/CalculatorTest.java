package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void 입력값_빈값_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator("");
                });
    }

    @Test
    void 입력값_null값_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(null);
                });
    }
}