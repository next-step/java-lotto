package lotto;

import lotto.domain.AutoLottosGenerator;
import lotto.domain.Lottos;
import lotto.domain.Ranks;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int count = InputView.purchaseCount();
        Lottos lottos = new Lottos(new AutoLottosGenerator(count));
        ResultView.printLottoNumber(lottos);

        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        Ranks lottoRanks = new Ranks(winLotto, bonusNumber);
        List<Rank> winningRanks = lottoRanks.getWinningLottoRanks(lottos);
        Map<Rank, Integer> lottoInsights = lottoRanks.updateLottoRank();

        ResultView.printLottoResult(lottoInsights);
        ResultView.getYield(lottoRanks.getTotalLottoWinningPrice(winningRanks), count);
    }
}
