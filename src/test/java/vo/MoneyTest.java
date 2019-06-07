package vo;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test(expected = IllegalArgumentException.class)
    public void 입력한_금액이_1000원_미만이면_exception(){
        new Money(900);
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
}