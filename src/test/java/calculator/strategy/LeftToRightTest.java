package calculator.strategy;

import calculator.domain.Input;
import calculator.domain.Operand;
import calculator.domain.Strings;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeftToRightTest {
    @Test
    void 왼쪽에서_오른쪽으로_순서대로_계산() {
        CalculationOrderStrategy calculationOrderStrategy = new LeftToRight();
        Strings strings = new Input("2 + 3 * 4 / 2").split();

        assertThat(calculationOrderStrategy.calculate(strings)).isEqualTo(new Operand("10"));
    }
}