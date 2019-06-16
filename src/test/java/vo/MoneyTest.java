package vo;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test(expected = IllegalArgumentException.class)
    public void 입력한_금액이_1000원_미만이면_exception(){
        //Give
        //When
        //Then
        new Money(900).lotteryCount();
    }

    @Test
    public void 생성가능한_로또_갯수() {
        //Given
        Money money = new Money("14000");

        //When
        int usingLotteryCount = money.lotteryCount();

        //Then
        assertThat(usingLotteryCount).isEqualTo(14);
    }

    @Test
    public void sum() {
        //Given
        Money money = new Money(10000);

        //When
        Money actual = money.sum(new Money(5000));

        //Then
        assertThat(actual).isEqualTo(new Money(15000));
    }

    @Test
    public void profitRate() {
        //Give
        Money prize = new Money(10000);
        Money investMoney = new Money(1000);

        //When
        double profitRate = investMoney.profitRate(prize);

        //Then
        assertThat(profitRate).isEqualTo(10);
    }
}