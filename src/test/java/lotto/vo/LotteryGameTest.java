package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGameTest {
    private LotteryGame lotteryGame;

    @Before
    public void setUp() {
        lotteryGame = new LotteryGame(ConstTest.MONEY_MILLION);
    }

    @Test
    public void 로또_생성() {
        //When
        Ranks rankIntegerMap = lotteryGame.getWinningStatistics(ConstTest.LOTTERY_NUMBER_DEFAULT);

        //Then
        assertThat(rankIntegerMap.rankPerWinningCount(Rank.FIRST_PLACE)).isGreaterThanOrEqualTo(0);
    }
}