package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RanksTest {
    @Test
    public void 당첨횟수를_구한다() {
        //6개 일치 (2000000000원)- 0개
        //Given
        LotteryGame game = new LotteryGame(ConstTest.moneyThousand);

        //When
        Ranks ranks = game.getWinningStatistics(ConstTest.lottery1);

        //Then
        assertThat(ranks.rankPerWinningCount(Rank.FIRST_PLACE)).isEqualTo(0);
    }

    @Test
    public void 당첨1위일때_당첨횟수를_구한다() {
        //Given
        Map<Rank, Integer> rankMappers = new HashMap<>();
        rankMappers.put(Rank.FIRST_PLACE, 3);

        //When
        Ranks mapper = new Ranks(rankMappers);

        //Then
        assertThat(mapper.rankPerWinningCount(Rank.FIRST_PLACE)).isEqualTo(3);
    }
}