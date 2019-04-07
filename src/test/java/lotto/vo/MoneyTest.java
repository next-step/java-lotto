package lotto.vo;


import org.junit.Test;

import static lotto.utils.ConstTest.moneyMillion;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void 구입한_금액만큼_로또_갯수가져오기_1개이상() {
        //Given
        Money money = new Money("14000");

        //When
        int lottoCnt = money.buyingTicketCount();

        //Then
        assertThat(lottoCnt).isEqualTo(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구입한_금액만큼_로또_갯수가져오기_1개미만() {
        new Money("100");
    }

    @Test
    public void 수익률이_0_5_보다크다() {
        //Given
        Money revenue = new Money(5_000);

        //When
        double profit = moneyMillion.yield(revenue);

        //Then
        assertThat(profit).isEqualTo(0.5);
    }
}