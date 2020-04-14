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
        ManualCount manualCount = new ManualCount(gameMoney, InputView.askManualPurchase());

        List<LottoNumbers> manualLottoNumbers = getManualLottoNumbers(manualCount.getManualCounts());
        LottoGenerator lottoGenerator = new LottoGenerator(gameMoney, manualCount, manualLottoNumbers);

        List<Lotto> purchasedLottos = lottoGenerator.getPurchasedLottos();
        outputView.showInputResult(purchasedLottos, gameMoney.getLottoCount(), manualCount.getManualCounts());
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

    private List<LottoNumbers> getManualLottoNumbers(int manualCounts) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        InputView.askManualLottoNumber();

        for (int i = 0; i < manualCounts; i++) {
            LottoNumbers lottoNumber = new LottoNumbers(InputView.manualLottoNumber());
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

}
