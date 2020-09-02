package step2.domain;

import step2.domain.lotto.BuyLotto;
import step2.domain.lotto.Lottos;
import step2.domain.lottoResult.LottoResults;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGame {
    public void play() {
        int purchaseAmount = InputView.inputPurchase();
        int manualLottoCount = InputView.inputManualLottoCount();

        BuyLotto buyLotto = new BuyLotto(purchaseAmount, manualLottoCount);
        List<String> manualLotto = InputView.inputManualLottoNumber(manualLottoCount);

        ResultView.printPurchaseLotto(buyLotto);
        Lottos lottos = buyLotto.lottoTicket(manualLotto);
        ResultView.printLottos(lottos);

        LottoResults prizes = lottos.getLottoResult(InputView.inputWinningNumber(), InputView.inputBonusNumber());

        ResultView.printLottoResult(prizes);
        ResultView.printProfitStatus(purchaseAmount, prizes);
    }
}
