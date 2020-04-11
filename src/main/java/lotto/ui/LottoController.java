package lotto.ui;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        Money gameMoney = new Money(inputView.askNumberOfPurchase());
        generateAutoLottos(purchasedLottos, gameMoney);

        outputView.showInputResult(purchasedLottos, gameMoney);
        WinningLotto winningLotto = generateWinningLotto();

        GameResult gameResult = getGameResult(purchasedLottos, winningLotto);
        outputView.showResult(gameResult);
        outputView.showProfit(gameMoney, gameResult);
    }

    private void generateAutoLottos(List<Lotto> purchasedLottos, Money money) {
        LottoAutoGenerator lottoNosGenerator = new LottoAutoGenerator();
        for (int i = 0; i < money.getLottoCount(); i++) {
            List<LottoNumber> lottoNumbers = lottoNosGenerator.getLottoNumbers();
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
    }

    private WinningLotto generateWinningLotto() {
        Lotto winningLotto = new Lotto((new LottoManualGenerator(inputView.askLastPrizeNumber()).generateNumbers()));
        LottoNumber bonusNumber = new LottoNumber(inputView.askBonusPrizeNumber());
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private GameResult getGameResult(final List<Lotto> purchasedLottos, final WinningLotto winningLotto) {
        GameResult gameResult = new GameResult();
        for (Lotto lotto : purchasedLottos) {
            gameResult.addWinResult(winningLotto.match(lotto));
        }
        return gameResult;
    }
}
