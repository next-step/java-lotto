package lotto;

import static lotto.view.InputView.*;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputManualLottoCount;
import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.ResultView.printLottosCount;
import static lotto.view.ResultView.printPurchaseLottoByEachType;
import static lotto.view.ResultView.printReturnRate;
import static lotto.view.ResultView.printWinningResult;

public class LottoProgram {

    public void run() {
        Money money = new Money(inputPurchaseAmount());
        PurchaseAmount amount = PurchaseAmount.of(money.purchase(), inputManualLottoCount());

        Lottos lottos = buyLotto(amount);
        printPurchaseLottoByEachType(amount);
        printLottosCount(lottos);

        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers(), inputBonusNumber());

        LottoResult lottoResult = winningLotto.getWinningResult(lottos);
        printWinningResult(lottoResult);
        printReturnRate(lottoResult.calculateReturnRate(amount.getTotal()));
    }

    private Lottos buyLotto(PurchaseAmount amount) {
        Lottos lottos = Lottos.of();
        lottos.add(
            Lottos.create(
                amount.getManual(),
                new ManualNumberGenerator(inputManualLottoNumbers(amount.getManual())
                )));
        lottos.add(Lottos.create(amount.getAuto(), new RandomNumberGenerator()));
        return lottos;
    }
}
