package lotto.vo;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class LotteryGeneratorTest {
    @Test
    public void 로또한장당_생성되는_로또번호() {
        LotteryGenerator lotteryGenerator = new LotteryGenerator();
        assertThat(lotteryGenerator.lotteryNumbers()).hasSize(6);
    }

    @Test
    public void 로또한장당_생성되는_보너스번호() {
        LotteryGenerator lottery = new LotteryGenerator();
        BonusNumber bonusNumber = lottery.addBonusNumber();
        assertThat(bonusNumber.bonusNumber).isGreaterThan(0);
    }
}