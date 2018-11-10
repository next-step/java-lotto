package game.lotto.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    private Money money;
    private Amount amount;

    @Before
    public void setup() {
        money = new Money(14000);
        amount = new Amount(money);
    }

    @Test
    public void 생성하기() {
        assertThat(amount.getValue()).isEqualTo(money.getValue() / Money.LOTTO_PRICE);
    }

    @Test
    public void 동등성_테스트() {
        final Amount other = new Amount(money);

        assertThat(amount).isEqualTo(other);
    }

}