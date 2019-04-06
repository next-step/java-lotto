package lotto.vo;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class LotteryGeneratorTest {
    @Test
    public void 로또한장당_생성되는_로또번호() {
        LotteryGenerator lotteryGenerator = new LotteryGenerator();
        LotteryNumbers lottery = lotteryGenerator.lotteryGenerator(new Money(1000));
        assertThat(lottery.lotteryNumbersCount()).isEqualTo(1);
    }
}