package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int purchaseAmount = InputView.purchaseAmount();
        Money money = new Money(purchaseAmount);

        int manualCount = InputView.purchaseManualCount();
        List<String> manualLottosNumbers = InputView.inputManualLottoNumbers(manualCount);

        Lottos manualLottos = new Lottos(new ManualLottosGenerator(manualLottosNumbers));
        Lottos autoLottos = new Lottos(new AutoLottosGenerator(money));
        manualLottos.addManualLottos(autoLottos.getLottos());
        ResultView.printLottoNumber(manualLottos);

        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        Ranks lottoRanks = new Ranks(winLotto, bonusNumber);
        List<Rank> winningRanks = lottoRanks.getWinningLottoRanks(manualLottos);
        Map<Rank, Integer> lottoInsights = lottoRanks.updateLottoRank();

        ResultView.printLottoResult(lottoInsights);
        ResultView.getYield(lottoRanks.getTotalLottoWinningPrice(winningRanks), money);
    }
}
