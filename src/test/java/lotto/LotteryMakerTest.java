package lotto;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class LotteryMakerTest {
    @Test
    public void 로또한장당_생성되는_로또번호() {
        LotteryMaker lotteryMaker = new LotteryMaker();
        assertThat(lotteryMaker.lotteryNumbers()).hasSize(6);
    }
}