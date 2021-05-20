package lotto.ui;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
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

        final WinningLotto winningLotto = lottoGenerator.generateWinningLotto(inputView.askLastPrizeNumber());
        GameResult gameResult = new GameResult(purchasedLottos, winningLotto);
        outputView.showResult(gameResult);
        outputView.showProfit(money, gameResult);
    }
}
