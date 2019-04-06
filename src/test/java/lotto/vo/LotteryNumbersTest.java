package lotto.vo;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryNumbersTest {
    public static final LotteryNumbers lotteryNumbers = new LotteryNumbers(Arrays.asList(LotteryNumberTest.lottery1, LotteryNumberTest.lottery2));
    @Test
    public void 티켓갯수에_따라_로또번호생성() {
        assertThat(lotteryNumbers.lotteryNumbersCount()).isEqualTo(2);
    }

    @Test
    public void PRINT_로또넘버() {
        System.out.println(lotteryNumbers);
    }
}