package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RevenueRateTest {

    @Test
    public void test_수익률_계산() {
        RevenueRate revenueRate = new RevenueRate(new Money(5000), new Money(14000));
        assertThat(revenueRate.rate)
            .isEqualTo(0.35);
    }

    @Test(expected = ArithmeticException.class)
    public void test_실패_소지금_0원() {
        new RevenueRate(new Money(5000), new Money(0));
    }
}
