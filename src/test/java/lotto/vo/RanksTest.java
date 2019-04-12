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
        LotteryGame game = new LotteryGame(ConstTest.MONEY_THOUSAND);

        //When
        Ranks ranks = game.getWinningStatistics(ConstTest.LOTTERY_NUMBER_DEFAULT);

        //Then
        assertThat(ranks.rankPerWinningCount(Rank.FIRST_PLACE)).isEqualTo(0);
    }

    @Test
    public void 당첨번호가_갯수_6개일치가_세_번_일때_당첨횟수를_구한다() {
        //Given
        Map<Rank, Integer> rankMappers = new HashMap<>();
        rankMappers.put(Rank.FIRST_PLACE, 3);

        //When
        int result = rankMappers.get(Rank.FIRST_PLACE);

        //Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 당첨번호가_갯수_3개일치가_두_번_일때_당첨합산금액_구한다() {
        //Given
        LotteryNumbers lotteryNumber = new LotteryNumbers(Arrays.asList(ConstTest.LOTTERY_NUMBER_DEFAULT, ConstTest.LOTTERY_NUMBER_DEFAULT));
        Ranks ranks = lotteryNumber.getRanks(ConstTest.LOTTERY_ACCORDANCE_THREE);
        Rank rank = Rank.FIRST_PLACE;

        //When
        String result = String.valueOf(rank.sumProfit(ranks));

        //Then
        assertThat(result).isEqualTo("10000");
    }
}