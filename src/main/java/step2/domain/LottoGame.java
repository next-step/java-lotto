package step2.domain;

import step2.domain.lotto.BuyLotto;
import step2.domain.lotto.Lottos;
import step2.domain.lottoResult.LottoResults;
import step2.util.LottoNumberGenerator;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGame {
    public void play() {
        int purchaseAmount = InputView.inputPurchase();
        int manualLottoCount = InputView.inputManualLottoCount();

        BuyLotto buyLotto = new BuyLotto(purchaseAmount);

        ResultView.printPurchaseLotto(buyLotto.getLottoQuantity());
        Lottos lottos = buyLotto.lottoTicket(new LottoNumberGenerator());
        ResultView.printLottos(lottos);

        LottoResults prizes = lottos.getLottoResult(InputView.inputWinningNumber(), InputView.inputBonusNumber());

        ResultView.printLottoResult(prizes);
        ResultView.printProfitStatus(purchaseAmount, prizes);
    }
}
