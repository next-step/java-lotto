package lotto.vo;


import org.junit.Before;
import org.junit.Test;

import static lotto.utils.ConstTest.moneyMillion;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    Money money;

    @Before
    public void setUp() throws Exception {
        money = new Money(5_000);
    }

    @Test
    public void 구입한_금액만큼_로또_갯수가져오기_1개이상() {
        //Given
        Money money = new Money("14000");

        //When
        int lottoCnt = money.divide(money);

        //Then
        assertThat(lottoCnt).isEqualTo(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구입한_금액만큼_로또_갯수가져오기_1개미만() {
        new Money("100");
    }

    @Test
    public void 수익률이_0_5_보다크다() {
        //When
        double profit = moneyMillion.yield(money);

        //Then
        assertThat(profit).isEqualTo(0.5);
    }

    @Test
    public void 로또_가격을_넘겨서_갯수_구해오기() {
        //When
        int result = money.divide(money);

        //Then
        assertThat(result).isEqualTo(5);
    }
}