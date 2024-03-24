package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoPlayer {

    private void play() {
        final Cash cash = new Cash(InputView.purchasePrice());

        final Lottos lottos = purchaseLotto(cash);
        if (lottos.isEmpty()) {
            return;
        }

        final Lotto lastWeekWinningNumbers = new Lotto(InputView.lastWeekWinningNumbers());
        final LottoNumber bonusNumber = new LottoNumber(InputView.bonusBallNumber());

        final Ranks ranks = lottos.ranks(lastWeekWinningNumbers, bonusNumber);
        printResult(ranks, cash);
    }

    private Lottos purchaseLotto(Cash cash) {
        final Lottos lottos = LotteryShop.purchase(cash);
        OutputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private void printResult(Ranks ranks, Cash cash) {
        final WinningStatistics statistics = new WinningStatistics(ranks);
        OutputView.printWinningCounts(statistics);

        final double rateOfReturn = statistics.rateOfReturn(cash);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    public static void main(String[] args) {
        final LottoPlayer lottoPlayer = new LottoPlayer();
        lottoPlayer.play();
    }
}
