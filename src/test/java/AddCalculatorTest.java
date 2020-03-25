import static org.assertj.core.api.Assertions.*;

import calculator.Calculator;
import org.junit.jupiter.api.Test;

public class AddCalculatorTest {
    @Test
    void 덧셈계산기_테스트() {
        String input = "";
        Calculator cal = new Calculator(input);
        assertThat(cal.getResult()).isEqualTo(0);
    }
}
