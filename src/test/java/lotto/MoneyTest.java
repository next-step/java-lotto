package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void countOfBuyingLotto() {
        Money money = new Money(20000);
        assertThat(money.countOfBuyingLotto()).isEqualTo(20);
    }

    @Test
    public void sum() {
        Money money = new Money(20000);
        Money actual = money.sum(new Money(2000));
        assertThat(actual).isEqualTo(new Money(22000));
    }

    @Test
    public void profitRate() {
        Money prize = new Money(1000);
        Money investMoney = new Money(10000);
        double profitRate = investMoney.rateOfReturn(prize);
        assertThat(profitRate).isEqualTo(10);
    }
}