package lotto.ui;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoAutoGenerator;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoManualGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseInformation;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * 로또의 사용자 요청을 처리한다.
 */
public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void start() {
        final Money money = new Money(inputView.askMoneyInput());
        final PurchaseInformation purchaseInformation = new PurchaseInformation(money, inputView.askManualPurchaseCount());
        final LottoGenerator autoLottoGenerator = new LottoAutoGenerator(purchaseInformation);
        Lottos purchasedLottos = new Lottos(autoLottoGenerator.generateLottos());
        final LottoGenerator manualLottoGenerator = new LottoManualGenerator(inputView.askManualLottos(purchaseInformation));
        purchasedLottos.addLottos(manualLottoGenerator.generateLottos());
        outputView.showInputResult(purchasedLottos, purchaseInformation);

        final Lotto winningLotto = new Lotto(inputView.askLastPrizeNumber());
        final LottoNumber bonusNumber = LottoNumber.of(inputView.askBonusPrizeNumber());
        final GameResult gameResult = new GameResult(purchasedLottos);
        outputView.showResult(gameResult, winningLotto, bonusNumber);
        outputView.showProfit(money, gameResult.getResult(winningLotto, bonusNumber));
    }
}
