package lotto.vo;


import lotto.utils.ConstTest;
import org.junit.Test;

import static lotto.utils.ConstTest.MONEY_MILLION;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test(expected = IllegalArgumentException.class)
    public void 구입한_금액만큼_로또_갯수가져오기_1개미만() {
        new Money("100");
    }

    @Test
    public void 수익률이_0_5_보다크다() {
        //When
        double profit = MONEY_MILLION.yield(ConstTest.MONEY_5_THOUSAND);

        //Then
        assertThat(profit).isEqualTo(0.5);
    }

    @Test
    public void 로또_가격을_인자로_넘겨서_갯수_구해오기() {
        //When
        int result = MONEY_MILLION.divide(ConstTest.MONEY_5_THOUSAND);

        //Then
        assertThat(result).isEqualTo(5);
    }
}