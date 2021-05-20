package lotto.ui;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        final LottoGenerator lottoGenerator = new LottoGenerator(money);
        final List<Lotto> purchasedLottos = lottoGenerator.getPurchasedLottos();
        outputView.showInputResult(purchasedLottos, money);

        final Lotto winningLotto = new Lotto(inputView.askLastPrizeNumber());
        final LottoNumber bonusNumber = new LottoNumber(inputView.askBonusPrizeNumber());
        final GameResult gameResult = new GameResult(purchasedLottos);
        outputView.showResult(gameResult, winningLotto, bonusNumber);
        outputView.showProfit(money, gameResult.getResult(winningLotto, bonusNumber));
    }
}
