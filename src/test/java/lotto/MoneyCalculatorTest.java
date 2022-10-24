package lotto;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1000:1.0", "14000:5000:0.35", "1000:20000:20.0", "14000:2000000000:142857.14"}, delimiter = ':')
    public void yield_test(BigDecimal purchasePrice, BigDecimal prizeMoney, double expectYield) {
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        double yield = moneyCalculator.calculateYield(purchasePrice, prizeMoney);
        assertThat(yield).isEqualTo(expectYield,  withPrecision(0.01));
    }
}
