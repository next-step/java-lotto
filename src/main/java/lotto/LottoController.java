package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.strategy.LottoGenerator;
import lotto.strategy.LottoRandomGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {

    public static void main(String[] args) {
        int purchasePrice = InputView.askPurchasePrice();

        LottoGenerator lottoRandomGenerator = new LottoRandomGenerator();
        LottoBundle lottoBundle = new LottoBundle(lottoRandomGenerator, purchasePrice);
        ResultView.printPurchaseInfo(lottoBundle);

        Lotto winningLotto = InputView.askLottoWinningNumbers();
        int bonusNumber = InputView.askBonusNumber();
        Map<LottoResult, Integer> lottoResults = lottoBundle.checkWinningResult(new WinningLotto(winningLotto, bonusNumber));
        ResultView.printWinningStatistics(purchasePrice, lottoResults);
    }

}
