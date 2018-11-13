package game.lotto.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    private Money money;
    private Amount amount;

    @Before
    public void setup() {
        money = new Money(5000);
    }

    @Test
    public void 생성하기() {
        final int manualCount = 5;
        Amount amount = new Amount(money, manualCount);

        assertThat(amount.getAutoCount()).isEqualTo(money.getValue() / Money.LOTTO_PRICE - manualCount);
        assertThat(amount.getManualCount()).isEqualTo(manualCount);
    }


    @Test(expected = IllegalArgumentException.class)
    public void 생성하기_수동갯수가_더_많을때() {
        final int manualCount = 6;
        Amount amount = new Amount(money, manualCount);

        assertThat(amount.getAutoCount()).isEqualTo(money.getValue() / Money.LOTTO_PRICE - manualCount);
    }

    @Test
    public void 동등성_테스트() {
        final int manualCount = 5;
        final Amount origin = new Amount(money, manualCount);
        final Amount other = new Amount(money, manualCount);

        assertThat(other).isEqualTo(origin);
    }

    @Test
    public void 동등성_테스트_객체넘겨_생성한거() {
        final int manualCount = 5;
        final Amount origin = new Amount(money, manualCount);
        final Amount other = new Amount(origin);

        assertThat(other).isEqualTo(origin);
    }

    @Test
    public void isSame() {
        Amount amount = new Amount(money, 0);
        final int sameCount = (money.getValue() / Money.LOTTO_PRICE);
        final int graterCount = sameCount + 1;

        assertThat(amount.isSameAutoCount(sameCount)).isTrue();
        assertThat(amount.isSameAutoCount(graterCount)).isFalse();
    }

    @Test
    public void getTotalAmount() {
        final int expectedCount = (money.getValue() / Money.LOTTO_PRICE);
        final Amount amount = new Amount(money, 2);

        assertThat(amount.getTotalAmount()).isEqualTo(expectedCount);
    }

}