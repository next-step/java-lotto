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

        LottoResult result = lottoService.createLotto(price); //로또 실행

        resultView.printCreateLotto(result);//몇장 구매

        String answer = inputView.inputAnswer();
        lottoService.calculateLotto(answer, result); //로또 당첨 계산

        LottoMargin lottoMargin = lottoService.calculateMarginRate(price, result); //로또 수익률 계산

        resultView.printResult(LottoResult.from(result, lottoMargin));
    }
}
