package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResultCalculator lottoResultCalculator;

    public LottoController(InputView inputView, OutputView outputView, LottoResultCalculator lottoResultCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoResultCalculator = lottoResultCalculator;
    }

    public void startGame() {
        LottoAmount autoLottoAmount = getLottoAmount();
        ManualLottoCount manualLottoAmount = getManualLottoCount();

        int manualLottoCount = manualLottoAmount.findLottoCount();
        Lottos manualLottos = getManualLottos(manualLottoCount);

        int autoLottoCount = getAutoLottoCount(autoLottoAmount, manualLottoCount);
        Lottos autoLottos = getAutoLottos(autoLottoCount, manualLottos);

        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = getBonusNumber();

        int totalLottoCount = manualLottoCount + autoLottoCount;
        Lottos totalLotts = new Lottos(manualLottos, autoLottos);

        Map<String, Integer> results = lottoResultCalculator.calculateResults(totalLotts, winningLotto, bonusNumber);
        double profit = lottoResultCalculator.calculateProfit(results, totalLottoCount);
        outputView.printResults(results, profit);
    }

    private int getAutoLottoCount(LottoAmount autoLottoAmount, int manualLottoCount) {
        int autoLottoCount = autoLottoAmount.findLottoCount();
        outputView.printLottoCount(manualLottoCount, autoLottoCount);
        return autoLottoCount;
    }

    private LottoNumber getBonusNumber() {
        outputView.askBonusLotto();
        LottoNumber bonusNumber = inputView.inputBonusLotto();
        return bonusNumber;
    }

    private Lotto getWinningLotto() {
        outputView.askWinningLotto();
        Lotto winningLotto = inputView.inputWinningLotto();
        return winningLotto;
    }

    private Lottos getAutoLottos(int autoLottoCount, Lottos manualLottos) {
        Lottos autoLottos = new Lottos(autoLottoCount);
        outputView.printLottos(manualLottos, autoLottos);
        return autoLottos;
    }

    private Lottos getManualLottos(int manualLottoCount) {
        outputView.askManualLottos();
        Lottos manualLottos = inputView.inputManualLotto(manualLottoCount);
        return manualLottos;
    }

    private ManualLottoCount getManualLottoCount() {
        outputView.askManualLottoAmount();
        ManualLottoCount manualLottoAmount = inputView.inputManualLottoCount();
        return manualLottoAmount;
    }

    private LottoAmount getLottoAmount() {
        outputView.askLottoAmount();
        LottoAmount autoLottoAmount = inputView.inputLottoAmount();
        return autoLottoAmount;
    }
}
