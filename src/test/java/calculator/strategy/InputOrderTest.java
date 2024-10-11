package calculator.strategy;

import calculator.domain.Input;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputOrderTest {
    @Test
    void 왼쪽에서_오른쪽으로_순서대로_계산() {
        CalculationOrderStrategy calculationOrderStrategy = new InputOrder();
        String[] values = new Input("2 + 3 * 4 / 2").split();
        assertThat(calculationOrderStrategy.calculate(values)).isEqualTo(10);
    }
}