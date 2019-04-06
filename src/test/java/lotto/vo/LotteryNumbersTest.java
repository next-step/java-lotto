package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryNumbersTest {
    public static final LotteryNumbers lotteryNumbers = new LotteryNumbers(Arrays.asList(ConstTest.lottery1, ConstTest.lottery2));

    @Test
    public void 티켓갯수에_따라_로또번호생성() {
        //When
        int lotteryNumberCount = lotteryNumbers.lotteryNumbersCount();

        //Then
        assertThat(lotteryNumberCount).isEqualTo(2);
    }

    @Test
    public void PRINT_로또넘버() {
        System.out.println(lotteryNumbers);
    }
}