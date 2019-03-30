package lotto;

import lotto.domain.Lottery;
import lotto.domain.LotteryNo;
import lotto.domain.Ranking;
import lotto.domain.WinnerLottery;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static lotto.domain.LotteryNo.makeLotteryNos;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class RankTest {
    static final int BONUS_NUMBER = 7;
    final Ranking ranking = Ranking.FIRST_CLASS;

    @Test
    public void 랭크_반환값_테스트() {
        assertThat(ranking.getRank(6, false)).isEqualTo(Ranking.FIRST_CLASS);
    }

    @Test
    public void 로또_금액_반환_테스트() {
        final Set<LotteryNo> lotteryNumbers = makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Set<LotteryNo> winnerNumbers = makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottery lottery = new Lottery(lotteryNumbers);
        WinnerLottery winnerLottery = new WinnerLottery(winnerNumbers, BONUS_NUMBER);

        assertThat(ranking.getProfit(lottery, winnerLottery)).isEqualTo(2000000000);
    }

    @Test
    public void 숫자로_넣은_후_값_반환_테스트() {
        Ranking ranking = Ranking.valueOf(6);

        assertThat(ranking.getRank(6, false)).isEqualTo(Ranking.FIRST_CLASS);
    }
}

