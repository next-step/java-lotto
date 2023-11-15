package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 기능")
    void name() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        assertThat(result).isEqualTo(3);
    }
}
