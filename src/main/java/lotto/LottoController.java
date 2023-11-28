package lotto;

import lotto.domain.*;
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
        LottoNumber bonusNumber = InputView.askBonusNumber();
        Map<LottoResult, Integer> lottoResults = lottoBundle.checkWinningResult(new WinningLotto(winningLotto, bonusNumber));
        ResultView.printWinningStatistics(purchasePrice, lottoResults);
    }

}
