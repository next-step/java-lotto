package calculator.domain.cal;

import calculator.domain.Calculable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DivisionCalTest {

    @Test
    void 나누기() {
        Calculable cal = new DivisionCal();
        int preResult = 10;
        int operand = 10;

        assertThat(cal.calculate(preResult, operand)).isEqualTo(1);
    }

    @Test
    void 나누기_0_에러() {
        Calculable cal = new DivisionCal();

        assertThatThrownBy(() -> cal.calculate(10, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
