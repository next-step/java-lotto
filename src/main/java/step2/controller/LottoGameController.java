package step2.controller;

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

        Lottos lottos = new Lottos(lottoGenerator.generateLottos(money.determineLottoPurchaseCount()));
        LottoResultView.printLottos(lottos);

        WinningLotto winningLotto = lottoGenerator.generateWinningLotto(
                LottoInputView.inputWinningLottoNumber(), LottoInputView.inputWinningLottoBonusNumber());

        LottoResult lottoResult = new LottoResult(lottos.calculateTotalRank(winningLotto));
        LottoResultView.printFinalLottoResult(lottoResult, money);

    }
}
