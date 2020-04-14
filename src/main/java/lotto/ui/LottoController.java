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
        List<Lotto> purchasedLottos = new ArrayList<>();
        Money gameMoney = new Money(inputView.askNumberOfPurchase());
        generateAutoLottos(purchasedLottos, gameMoney);

        int manualPurchase = validateCounts(gameMoney, inputView.askManualPurchase());
        List<Lotto> userLottos = inputManualLotto(manualPurchase);

        outputView.showInputResult(purchasedLottos, gameMoney.getLottoCount(), manualPurchase);
        WinningLotto winningLotto = generateWinningLotto();

        GameResult gameResult = getGameResult(purchasedLottos, winningLotto);
        outputView.showResult(gameResult);
        outputView.showProfit(gameMoney, gameResult);
    }


    private List<Lotto> inputManualLotto(int manualPurchased) {
        List<Lotto> manualLottos = new ArrayList<>();
        inputView.askManualLottoNumber();

        for (int i = 0; i < manualPurchased; i++) {
            List<LottoNumber> lottoNumbers = new LottoManualGenerator(inputView.ManualLottoNumber()).generateNumbers();
            manualLottos.add(new Lotto(lottoNumbers));
        }
        return manualLottos;
    }

    private int validateCounts(Money money, int manualPurchase) {
        if (manualPurchase > money.getLottoCount()) {
            throw new IllegalArgumentException(OVER_BUDGET);
        }
        return manualPurchase;
    }

    private void generateAutoLottos(List<Lotto> purchasedLottos, Money money) {
        for (int i = 0; i < money.getLottoCount(); i++) {
            List<LottoNumber> lottoNumbers = LottoAutoGenerator.getLottoNumbers();
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
