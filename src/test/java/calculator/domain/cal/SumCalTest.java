package calculator.domain.cal;

import calculator.domain.Calculable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumCalTest {

    @Test
    void 더하기() {
        Calculable cal = new SumCal();
        int preResult = 10;
        int operand = 10;

        assertThat(cal.calculate(preResult, operand)).isEqualTo(20);
    }
}
