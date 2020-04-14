package lotto.ui;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static final String OVER_BUDGET = "구입 금액 초과";
    private final OutputView outputView;

    public LottoController() {
        this.outputView = new OutputView();
    }

    public void start() {
        Money gameMoney = new Money(InputView.askNumberOfPurchase());
        int manualPurchase = validateCounts(gameMoney, InputView.askManualPurchase());
        LottoGenerator lottoGenerator = new LottoGenerator(gameMoney, manualPurchase);
        InputView.askManualLottoNumber();

        List<Lotto> purchasedLottos = lottoGenerator.getPurchasedLottos();
        outputView.showInputResult(purchasedLottos, gameMoney.getLottoCount(), manualPurchase);
        WinningLotto winningLotto = lottoGenerator.generateWinningLotto(
                InputView.askLastPrizeNumber(), InputView.askBonusPrizeNumber());

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
