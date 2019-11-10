package lotto;

import lotto.domain.AutoLottosGenerator;
import lotto.domain.LottoPaper;
import lotto.domain.Ranks;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int count = InputView.purchaseCount();
        LottoPaper lottoPaper = new LottoPaper(count, new AutoLottosGenerator());
        ResultView.printLottoNumber(lottoPaper);
        List<Rank> ranks = getWinLotto(lottoPaper);

        Ranks lottoRanks = new Ranks(ranks);
        Map<Rank, Integer> lottoInsights = lottoRanks.updateLottoRank();

        ResultView.printLottoResult(lottoInsights);
        ResultView.getYield(lottoRanks.getTotalLottoWinningPrice(), count);
    }

    private List<Rank> getWinLotto(LottoPaper lottoPaper) {
        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        return lottoPaper.getWinningLottoRanks(winLotto, bonusNumber);
    }
}
