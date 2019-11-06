package lotto;

import lotto.domain.LottoPaper;
import lotto.domain.Ranks;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int count = InputView.purchaseCount();
        LottoPaper lottoPaper = new LottoPaper(count);
        printLottoNumber(lottoPaper);
        List<Rank> ranks = getWinLotto(lottoPaper);

        Ranks lottoRanks = new Ranks(ranks);
        Map<Rank, Integer> lottoRanksCount = lottoRanks.getLottoRankCount();

        printLottoResult(lottoRanksCount);
        printYield(lottoRanks.getTotalLottoWinningPrice(), count);

    }

    private void printYield(int totalPrice, int count) {
        ResultView.getYield(totalPrice, count);
    }

    private void printLottoResult(Map<Rank, Integer> ranks) {
        ResultView.printLottoResult(ranks);
    }

    private List<Rank> getWinLotto(LottoPaper lottoPaper) {
        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        return lottoPaper.getWinningLottoRanks(winLotto, bonusNumber);
    }

    private void printLottoNumber(LottoPaper lottoPaper) {
        ResultView.printLottoNumber(lottoPaper);
    }
}
