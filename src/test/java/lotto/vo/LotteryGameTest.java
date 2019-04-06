package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGameTest {
    private Money money;
    private LotteryGame lotteryGame;

    @Before
    public void setUp() {
        money = new Money(10_100);
        lotteryGame = new LotteryGame(money);
    }

    @Test
    public void 로또_생성() {
        //When
       Ranks rankIntegerMap = lotteryGame.getWinningStatistics(ConstTest.lottery1);

        //Then
        assertThat(rankIntegerMap.rankPerWinningCount(Rank.FIRST_PLACE)).isGreaterThanOrEqualTo(0);
    }
}