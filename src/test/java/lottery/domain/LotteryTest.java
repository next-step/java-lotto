package lottery.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    public void 당첨번호_맞는지_체크() {
        Lottery lottery = Fixture.oneToSixLottery;
        Lottery mockLottery = Fixture.oneToSixBonusBallLottery;
        RANK result = lottery.winCheck(mockLottery);
        assertThat(result) .isEqualTo(RANK.FIRST);
    }

    @Test
    public void 보너스볼도체크() {
        Lottery lottery = Fixture.oneToSixLottery;
        Lottery mockLottery = Fixture.createLotteryWithBonus(6, 1,2,3,4,5,7);
        RANK result = lottery.winCheck(mockLottery);
        assertThat(result) .isEqualTo(RANK.SECOND);
    }
}