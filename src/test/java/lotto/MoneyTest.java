package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @Test
    void 구매금액만큼_로또를_최대치_구입한다() {
        int lotto = 1000;
        int amount = 14000;
        Money lottoPrice = new Money(lotto);
        Money budget = new Money(amount);

        assertThat(budget.purchase(lottoPrice)).isEqualTo(amount / lotto);
    }

    @Test
    void 구매금액이_부족하면_예외를_던진다() {
        int lotto = 1000;
        int budget = 900;
        Money lottoPrice = new Money(lotto);
        Money budgetOnPocket = new Money(budget);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> budgetOnPocket.purchase(lottoPrice));
    }

    @Test
    void multiply_amount() {
        Money money = new Money(1000);
        assertThat(money.multiply(3)).isEqualTo(new Money(3000));
    }

    @Test
    void 총_수익률_계산() {
        Money totalPrize = new Money(100000);
        Money budget = new Money(1000);

        assertThat(totalPrize.calculateRatio(budget)).isEqualTo(new Ratio(100));
    }

    @Test
    void sum() {
        assertThat(new Money(1000).sum(new Money(3000)))
                .isEqualTo(new Money(4000));
    }
}