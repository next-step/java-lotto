package lotto.vo;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {
    @Test
    public void 구입한_금액만큼_로또_갯수가져오기_1개이상() {
        Money money = new Money("14000");
        int lottoCnt = money.getLotto();
        assertThat(lottoCnt).isEqualTo(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구입한_금액만큼_로또_갯수가져오기_1개미만() {
        new Money("100");
    }

    @Test
    public void 수익률() {
        Money money = new Money(10000);
        Money revenue = new Money(5000);
        assertThat(money.yield(revenue)).isEqualTo(0.5);
    }
}