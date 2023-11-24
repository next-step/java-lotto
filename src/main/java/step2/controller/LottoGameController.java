package step2.controller;

import java.util.List;
import step2.model.Lotto;
import step2.model.LottoGenerator;
import step2.model.WinningLotto;
import step2.view.LottoInputView;
import step2.model.LottoResult;
import step2.view.LottoResultView;
import step2.model.Lottos;
import step2.model.Money;

public class LottoGameController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void game() {
        Money money = new Money(LottoInputView.inputPurchaseMoney());

        Lottos lottos = new Lottos(generateLottos(money));
        LottoResultView.printLottos(lottos, money);

        WinningLotto winningLotto = lottoGenerator.generateWinningLotto(
                LottoInputView.inputWinningLottoNumber(), LottoInputView.inputWinningLottoBonusNumber());

        LottoResult lottoResult = new LottoResult(lottos.calculateTotalRank(winningLotto));
        LottoResultView.printFinalLottoResult(lottoResult, money);

    }

    public List<Lotto> generateLottos(Money money) {

        int manualLottoCount = LottoInputView.inputPurchaseManualLottoCount();
        Money moneyAfterPurchaseManualLotto = money.purchaseManualLotto(manualLottoCount);

        return lottoGenerator.generateLottos(LottoInputView.inputManualLottoNumbers(manualLottoCount),
                moneyAfterPurchaseManualLotto);
    }
}
