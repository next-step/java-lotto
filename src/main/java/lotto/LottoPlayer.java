package lotto;

import lotto.domain.Amount;
import lotto.domain.Cash;
import lotto.domain.LotteryShop;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.Ranks;
import lotto.domain.statistics.RateOfReturn;
import lotto.domain.statistics.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoPlayer {

    private void play() {
        final Cash cash = new Cash(InputView.purchasePrice());

        final Lottos lottos = purchaseLotto(cash);
        if (lottos.isEmpty()) {
            return;
        }

        final WinningLotto winningLotto = winningLotto();
        final Ranks ranks = lottos.ranks(winningLotto);

        printResult(ranks, cash);
    }

    private Lottos purchaseLotto(Cash cash) {
        final Amount manualAmount = new Amount(InputView.manualAmount());


        final Lottos lottos = LotteryShop.purchaseAuto(cash);
        OutputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private WinningLotto winningLotto() {
        final Lotto lastWeekWinningNumbers = new Lotto(InputView.lastWeekWinningNumbers());
        final LottoNumber bonusNumber = new LottoNumber(InputView.bonusBallNumber());

        return new WinningLotto(lastWeekWinningNumbers, bonusNumber);
    }

    private void printResult(Ranks ranks, Cash spentCash) {
        final WinningStatistics statistics = new WinningStatistics(ranks);
        OutputView.printWinningCounts(statistics);

        final RateOfReturn rateOfReturn = statistics.rateOfReturn(spentCash);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    public static void main(String[] args) {
        final LottoPlayer lottoPlayer = new LottoPlayer();
        lottoPlayer.play();
    }
}
