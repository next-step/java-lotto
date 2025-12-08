package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void getLottoTicketCount() {
        Money money = new Money(10000);
        assertThat(money.getLottoTicketCount()).isEqualTo(10);
    }

    @Test
    public void buy_수동구매로또() {
        Money money = new Money(10000);
        Money balance = money.subtractPurchaseAmount(3);
        assertThat(balance).isEqualTo(new Money(7000));
    }

    @Test
    public void add() {
        Money money = new Money(10000);
        Money actual = money.add(new Money(5000));
        assertThat(actual).isEqualTo(new Money(15000));
    }

    @Test
    public void calculateProfitRate() {
        Money prize = new Money(1000);
        Money investMoney = new Money(10000);
        double profitRate = investMoney.calculateProfitRate(prize);
        assertThat(profitRate).isEqualTo(10);
    }
}
