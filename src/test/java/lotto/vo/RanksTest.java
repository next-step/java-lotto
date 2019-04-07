package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RanksTest {
    @Test
    public void 당첨횟수를_구한다() {
        //Given
        LotteryGame game = new LotteryGame(ConstTest.moneyThousand);

        //When
        Ranks ranks = game.getWinningStatistics(ConstTest.lottery1);

        //Then
        assertThat(ranks.rankPerWinningCount(Rank.FIRST_PLACE)).isEqualTo(0);
    }

    @Test
    public void 당첨1위가_두번_일때_당첨횟수를_구한다() {
        //Given
        Map<Rank, Integer> rankMappers = new HashMap<>();
        rankMappers.put(Rank.FIRST_PLACE, 3);

        //When
        int result = rankMappers.get(Rank.FIRST_PLACE);

        //Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 당첨번호가_4위가_두번일때_당첨합산금액_구한다() {
        //Given
        LotteryNumbers lotteryNumber = new LotteryNumbers(Arrays.asList(ConstTest.lottery1, ConstTest.lottery1));
        Ranks ranks = lotteryNumber.getRanks(ConstTest.lotteryForth);
        Rank rank = Rank.FIRST_PLACE;

        //When
        String result = String.valueOf(rank.sumProfit(ranks));

        //Then
        assertThat(result).isEqualTo("10000");
    }

}