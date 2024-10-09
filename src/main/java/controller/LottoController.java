package controller;

import view.InputView;
import view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        int lottoPrice = inputView.getLottoPrice();
        resultView.printLottoCount(lottoPrice);


    }
}
