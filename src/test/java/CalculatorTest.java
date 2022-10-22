import org.junit.jupiter.api.Test;
import util.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 수익률계산() {
        long cost = 15000;
        long profit = 5000;
        String expected = "0.33";

        assertThat(Calculator.rateOfProfit(cost, profit)).isEqualTo(expected);
    }
}
