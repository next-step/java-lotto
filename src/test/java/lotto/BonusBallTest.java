package lotto;

import lotto.domain.*;
import org.assertj.core.api.Java6Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static lotto.domain.LotteryNo.makeLotteryNos;
import static lotto.domain.Ranking.SECOND_CLASS;
import static lotto.domain.Ranking.THIRD_CLASS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BonusBallTest {
    static final int BONUS_NUMBER = 13;
    static final Ranking SECOND_RANKING = Ranking.getRank(5, true);
    static final Ranking THIRD_RANKING = Ranking.getRank(5, false);

    final Lottery lottery = new Lottery(makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @Test
    public void 보너스_랭크_반환값_테스트() {
        Java6Assertions.assertThat(SECOND_RANKING).isEqualTo(SECOND_CLASS);
    }

    @Test
    public void 삼등_랭크_반환값_테스트() {
        Java6Assertions.assertThat(THIRD_RANKING).isEqualTo(THIRD_CLASS);
    }

    @Test
    public void 로또_금액_이등_반환_테스트() {
        final Lottery winnerNumber = new Lottery(makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 13)));
        final WinnerLottery winnerLottery = new WinnerLottery(winnerNumber, BONUS_NUMBER);

        Java6Assertions.assertThat(SECOND_RANKING.getProfit(lottery, winnerLottery)).isEqualTo(3_000_000);
    }

    @Test
    public void 로또_맞춘_개수_테스트() {
        final Set<LotteryNo> winnerLottery = makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottery.generationLottery(winnerLottery);

        assertThat(lottery.matchNumber(3, new LotteryNo(4))).isEqualTo(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스볼이_지난주_당첨번호에_포함되어있는지_확인한다() {
        BonusBall bonusBall = new BonusBall(5);

        bonusBall.checkBonusBallValidation(lottery);
    }
}
