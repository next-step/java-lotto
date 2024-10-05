package calculator.domain.cal;

import calculator.domain.Calculable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationCalTest {

    @Test
    void 곱하기() {
        Calculable cal = new MultiplicationCal();
        int preResult = 10;
        int operand = 10;

        assertThat(cal.calculate(preResult, operand)).isEqualTo(100);
    }
}
