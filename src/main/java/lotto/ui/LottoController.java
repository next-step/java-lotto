package lotto.ui;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final OutputView outputView;

    public LottoController() {
        this.outputView = new OutputView();
    }

    public void start() {
        Money gameMoney = new Money(InputView.askNumberOfPurchase());
        MannualCount mannualCount = new MannualCount(gameMoney, InputView.askManualPurchase());
        LottoGenerator lottoGenerator = new LottoGenerator(gameMoney, mannualCount.getManualCounts());
        InputView.askManualLottoNumber();

        List<Lotto> purchasedLottos = lottoGenerator.getPurchasedLottos();
        outputView.showInputResult(purchasedLottos, gameMoney.getLottoCount(), mannualCount.getManualCounts());
        WinningLotto winningLotto = lottoGenerator.generateWinningLotto(
                InputView.askLastPrizeNumber(), InputView.askBonusPrizeNumber());

        GameResult gameResult = getGameResult(purchasedLottos, winningLotto);
        outputView.showResult(gameResult);
        outputView.showProfit(gameMoney, gameResult);
    }

    private GameResult getGameResult(final List<Lotto> purchasedLottos, final WinningLotto winningLotto) {
        GameResult gameResult = new GameResult();
        for (Lotto lotto : purchasedLottos) {
            gameResult.addWinResult(winningLotto.match(lotto));
        }
        return gameResult;
    }
}
