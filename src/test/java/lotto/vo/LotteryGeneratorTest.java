package lotto.vo;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class LotteryGeneratorTest {
    @Test
    public void 로또한장당_생성되는_로또번호() {
        //Given
        LotteryGenerator lotteryGenerator = new LotteryGenerator();
        LotteryNumbers lottery = lotteryGenerator.lotteryGenerator(new Money(1000));

        //When
        int lottoSize = lottery.lotteryNumbersCount();

        //Then
        assertThat(lottoSize).isEqualTo(1);
    }
}