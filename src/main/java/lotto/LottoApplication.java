package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
        LottoGame lottoGame = new LottoGame(purchaseAmount, new RandomLottoGenerator());
        OutputView.printLottos(lottoGame.getLottos());

        WinningLotto winningLotto = new WinningLotto(new Lotto(InputView.readWinningNumbers()));
        LottoResult result = lottoGame.getResult(winningLotto);
        OutputView.printResult(result);
    }
}
