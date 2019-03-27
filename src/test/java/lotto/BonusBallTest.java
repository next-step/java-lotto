package lotto;

import lotto.domain.Lottery;
import lotto.domain.MatchingCount;
import lotto.domain.Ranking;
import org.assertj.core.api.Java6Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static lotto.domain.Ranking.SECOND_CLASS;
import static lotto.domain.Ranking.THIRD_CLASS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BonusBallTest {
    Ranking second_ranking = MatchingCount.getRank(5, true);
    Ranking third_ranking = MatchingCount.getRank(5, false);
    final Set<Integer> lotteryNumber = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

    @Test
    public void 보너스_랭크_반환값_테스트() {
        Java6Assertions.assertThat(second_ranking).isEqualTo(SECOND_CLASS);
    }

    @Test
    public void 삼등_랭크_반환값_테스트() {
        Java6Assertions.assertThat(third_ranking).isEqualTo(THIRD_CLASS);
    }

    @Test
    public void 로또_랭킹_테스트() {
        Java6Assertions.assertThat(second_ranking.getCountMatching()).isEqualTo(5);
    }

    @Test
    public void 로또_금액_반환_테스트() {
        Java6Assertions.assertThat(second_ranking.getProfit()).isEqualTo(3_000_000);
    }

    @Test
    public void 로또_맞춘_개수_테스트() {
        Lottery lottery = new Lottery(lotteryNumber);

        Set<Integer> winnerLottery = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        lottery.generationLottery(winnerLottery);

        assertThat(lottery.matchNumber(3, 4)).isEqualTo(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스볼이_지난주_당첨번호에_포함되어있는지_확인한다() {
        BonusBall bonusBall = new BonusBall(5);

        bonusBall.checkBonusBallValidation(lotteryNumber);
    }
}
