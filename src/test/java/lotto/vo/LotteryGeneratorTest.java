package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class LotteryGeneratorTest {
    @Test
    public void 로또한장당_생성되는_로또번호() {
        //Given
        LotteryGenerator lotteryGenerator = new LotteryGenerator();
        LotteryNumbers lottery = lotteryGenerator.lotteryGenerator(ConstTest.MONEY_THOUSAND);

        //When
        int lottoSize = lottery.getLotteryNumbersCount();

        //Then
        assertThat(lottoSize).isEqualTo(1);
    }
}