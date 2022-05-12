package lotto;

import lotto.domain.result.LottoGameResult;
import lotto.domain.Lottos;
import lotto.domain.Winner;
import lotto.ui.LottoScanner;
import lotto.ui.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseAmount = LottoScanner.insertPurchaseAmount();
        Lottos lottos = Lottos.of(purchaseAmount);
        ResultView.printLottos(lottos);

        String winningNumbers = LottoScanner.insertWinningNumbers();
        Winner winner = Winner.of(winningNumbers);

        LottoGameResult lottoGameResult = winner.findWinners(lottos);
        ResultView.printLottoGameResult(lottoGameResult);
    }
}
