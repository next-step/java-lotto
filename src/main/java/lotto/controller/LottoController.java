package lotto.controller;

import lotto.model.ResultLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void buy() {
        int seedMoney = InputView.inputSeedMoney();
        ResultLotto resultLotto = lottoService.buyLottos(seedMoney);

        ResultView.viewLottos(resultLotto);
        List<Integer> winningNumbers = InputView.inputWinningNumbers();

        resultLotto = lottoService.checkLottoResult(winningNumbers);
        ResultView.viewResult(resultLotto);
    }
}
