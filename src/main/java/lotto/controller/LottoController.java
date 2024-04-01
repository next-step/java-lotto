package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void buy() {
        int seedMoney = InputView.inputSeedMoney();
        int manualLottoCount = InputView.inputManualCount();
        List<List<Integer>> manualLottoNumbers = InputView.inputLottosNumbers(manualLottoCount);
        int remainMoney = lottoService.buyManualLotto(seedMoney, manualLottoCount, manualLottoNumbers);

        ResultView.viewLottos(lottoService.buyLottos(seedMoney));
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBounusNumber();

        ResultView.viewResult(lottoService.checkLottoResult(winningNumbers, bonusNumber));
    }
}
