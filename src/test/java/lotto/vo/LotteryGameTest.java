package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

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
        Map<Rank, Integer> rankIntegerMap = lotteryGame.getWinningStatistics(ConstTest.lottery1);

        //Then
        assertThat(rankIntegerMap).isNotEmpty();
    }
}