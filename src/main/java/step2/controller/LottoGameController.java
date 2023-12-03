package step2.controller;

import java.util.List;
import step2.model.Lotto;
import step2.model.LottoMachine;
import step2.model.WinningLotto;
import step2.view.LottoInputView;
import step2.model.LottoResult;
import step2.view.LottoResultView;
import step2.model.Lottos;
import step2.model.Money;

public class LottoGameController {

    private final LottoMachine lottoMachine = new LottoMachine();

    public void game() {
        Money money = new Money(LottoInputView.inputPurchaseMoney());

        Lottos lottos = new Lottos(generateLottos(money));
        LottoResultView.printPurchaseLotto(lottos);

        WinningLotto winningLotto = lottoMachine.generateWinningLotto(
                LottoInputView.inputWinningLottoNumber(), LottoInputView.inputWinningLottoBonusNumber());

        LottoResult lottoResult = new LottoResult(lottos.calculateTotalRank(winningLotto));
        LottoResultView.printFinalLottoResult(lottoResult, money);
    }

    public List<Lotto> generateLottos(Money money) {

        int manualLottoCount = LottoInputView.inputPurchaseManualLottoCount();
        Money moneyAfterPurchaseManualLotto = money.purchaseManualLotto(manualLottoCount);

        List<Lotto> lottos = lottoMachine.generateLottos(LottoInputView.inputManualLottoNumbers(manualLottoCount),
                moneyAfterPurchaseManualLotto);

        LottoResultView.printLottosCount(manualLottoCount, moneyAfterPurchaseManualLotto);

        return lottos;
    }
}
