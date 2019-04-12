package lotto.vo;

import org.junit.Test;

import static lotto.utils.ConstTest.LOTTERY_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;


public class LotteryNumbersTest {
    @Test
    public void 티켓갯수에_따라_로또번호생성() {
        //When
        int lotteryNumberCount = LOTTERY_NUMBERS.getLotteryNumbersCount();

        //Then
        assertThat(lotteryNumberCount).isEqualTo(2);
    }

    @Test
    public void PRINT_로또넘버() {
        System.out.println(LOTTERY_NUMBERS);
    }
}