package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
        Lottos lottos = Lottos.generate(purchaseAmount.getLottoCount(), new RandomLottoGenerator());
        OutputView.printLottos(lottos.getLottos());

        WinningLotto winningLotto = new WinningLotto(new Lotto(InputView.readWinningNumbers()));
        LottoResult result = lottos.getResult(winningLotto, purchaseAmount);
        OutputView.printResult(result);
    }
}
