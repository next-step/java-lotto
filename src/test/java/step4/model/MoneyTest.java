package step4.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void 수익률테스트() {
        Money money = new Money(14000);
        assertThat(money.getProfit(new Money(5000))).isEqualTo(0.35);
        assertThat(money.getProfit(new Money(0))).isEqualTo(0);
    }
}
