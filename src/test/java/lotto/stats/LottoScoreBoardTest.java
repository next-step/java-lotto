package lotto.stats;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.machine.TestLottoGenerator;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;
import lotto.domain.shop.Money;
import lotto.domain.stats.LottoScoreBoard;
import lotto.domain.stats.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoScoreBoardTest {
    private LottoShop lottoShop;
    private WinningLotto winningLotto;

    @BeforeEach
    @DisplayName("로또 14개를 구입한다.")
    void prepareTestScenario() {
        lottoShop = new LottoShop(new Money(14000), new TestLottoGenerator(0));
        Lotto lotto = new Lotto(17, 18, 19, 20, 21, 22);
        winningLotto = new WinningLotto(lotto, new LottoBall(45));
    }

    @Test
    @DisplayName("당첨금이 5000원인 경우 수익률을 계산한다.")
    void lottoEarningRateCalculateTest() {
        LottoOrderedList lottoOrderedList = lottoShop.purchase();

        LottoScoreBoard lottoScoreBoard = LottoScoreBoard.create(lottoOrderedList, winningLotto);

        assertThat(lottoScoreBoard.getEarningRate()).isEqualTo("0.35");
    }

    @Test
    @DisplayName("보너스볼이 들어가면, 2등에 당첨된다.")
    void lottoBonusPrizeTest() {
        LottoShop lottoShop = new LottoShop(new Money(2000), new TestLottoGenerator(0));
        WinningLotto winnerLotto = new WinningLotto(new Lotto(2, 3, 4, 5, 6, 8), new LottoBall(1));
        LottoOrderedList lottoOrderedList = lottoShop.purchase();
        LottoScoreBoard lottoScoreBoard = LottoScoreBoard.create(lottoOrderedList, winnerLotto);

        long winner = lottoScoreBoard.getWinnerCountByPrize(Prize.SECOND);

        assertThat(winner).isEqualTo(1L);
    }
}
