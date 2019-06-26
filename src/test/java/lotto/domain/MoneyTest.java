package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void countOfBuyingLotto() {
        Money money = new Money(10000);
        assertThat(money.countOfBuyingLotto()).isEqualTo(10);
    }

    @Test
    public void buy_수동구매로또() {
        Money money = new Money(10000);
        Money balance = money.buyManual(3);
        assertThat(balance).isEqualTo(new Money(7000));
    }

    @Test
    public void sum() {
        Money money = new Money(10000);
        Money actual = money.sum(new Money(5000));
        assertThat(actual).isEqualTo(new Money(15000));
    }

    @Test
    public void profitRate() {
        Money prize = new Money(1000);
        Money investMoney = new Money(10000);
        double profitRate = investMoney.profitRate(prize);
        assertThat(profitRate).isEqualTo(10);
    }
}
