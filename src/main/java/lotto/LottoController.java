package lotto;

import lotto.domain.AutoLottosGenerator;
import lotto.domain.Lottos;
import lotto.domain.ManualLottosGenerator;
import lotto.domain.Ranks;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int countAll = InputView.purchaseCount();
        int manualCount = InputView.purchaseManualCount();
        List<String> manualLottosNumbers = InputView.inputManualLottoNumbers(manualCount);

        Lottos manualLottos = new Lottos(new ManualLottosGenerator(manualLottosNumbers));
        Lottos autoLottos = new Lottos(new AutoLottosGenerator(countAll - manualCount));


        ResultView.printLottoNumber(autoLottos);

        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        Ranks lottoRanks = new Ranks(winLotto, bonusNumber);
        List<Rank> winningRanks = lottoRanks.getWinningLottoRanks(autoLottos);
        Map<Rank, Integer> lottoInsights = lottoRanks.updateLottoRank();

        ResultView.printLottoResult(lottoInsights);
        ResultView.getYield(lottoRanks.getTotalLottoWinningPrice(winningRanks), countAll);
    }
}
