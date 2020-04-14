package lotto.ui;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static final String OVER_BUDGET = "구입 금액 초과";
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Money gameMoney = new Money(inputView.askNumberOfPurchase());
        int manualPurchase = validateCounts(gameMoney, inputView.askManualPurchase());
        LottoGenerator lottoGenerator = new LottoGenerator(gameMoney, manualPurchase);

        List<Lotto> purchasedLottos = lottoGenerator.getPurchasedLottos();

        outputView.showInputResult(purchasedLottos, gameMoney.getLottoCount(), manualPurchase);
        WinningLotto winningLotto = lottoGenerator.generateWinningLotto();

        GameResult gameResult = getGameResult(purchasedLottos, winningLotto);
        outputView.showResult(gameResult);
        outputView.showProfit(gameMoney, gameResult);
    }

    private int validateCounts(Money money, int manualPurchase) {
        if (manualPurchase > money.getLottoCount()) {
            throw new IllegalArgumentException(OVER_BUDGET);
        }
        return manualPurchase;
    }

    private GameResult getGameResult(final List<Lotto> purchasedLottos, final WinningLotto winningLotto) {
        GameResult gameResult = new GameResult();
        for (Lotto lotto : purchasedLottos) {
            gameResult.addWinResult(winningLotto.match(lotto));
        }
        return gameResult;
    }
}
