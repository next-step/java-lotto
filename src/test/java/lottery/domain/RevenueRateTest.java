package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RevenueRateTest {

    @Test
    public void test_수익률_계산() {
        RevenueRate revenueRate = new RevenueRate(Money.valueOf(5000), Money.valueOf(14000));
        assertThat(revenueRate.rate)
            .isEqualTo(0.35);
    }

    @Test(expected = ArithmeticException.class)
    public void test_실패_소지금_0원() {
        new RevenueRate(Money.valueOf(5000), Money.ZERO);
    }
}
