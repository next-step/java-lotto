package lotto.controller;

import lotto.lotto.LottoMargin;
import lotto.lotto.LottoResult;
import lotto.lotto.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startLotto() {
        int price = inputView.inputPrice();

        LottoService lottoService = new LottoService();

        LottoResult result = lottoService.createLotto(price);

        resultView.printCreateLotto(result);

        String answer = inputView.inputAnswer();
        int bonusNumber = inputView.inputBonus();

        lottoService.calculateLotto(answer, result, bonusNumber);

        LottoMargin lottoMargin = lottoService.calculateMarginRate(price, result);

        resultView.printResult(LottoResult.from(result, lottoMargin));
    }
}
