import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import util.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @Order(1)
    public void 수익률계산() {
        long cost = 15000;
        long profit = 5000;
        String expected = "0.33";

        assertThat(Calculator.rateOfProfit(cost, profit)).isEqualTo(expected);
    }

    @Test
    @Order(2)
    public void 나눗셈_실패() {
        long dividend = 1;
        long divisor = 0;
        assertThatThrownBy(
                () -> Calculator.divide(dividend, divisor)
        ).isInstanceOf(ArithmeticException.class);
    }

}
