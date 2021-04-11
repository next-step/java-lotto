package controller;

import domain.LottoGame;
import view.InputView;
import view.ResultView;

public class LottoController {

    public void start() {
        InputView inputView = new InputView();
        LottoGame lottoGame = new LottoGame(inputView.buyLotto(), inputView.findStickLottoNumbers());
        inputView.findWinNumbers();
        ResultView resultView = new ResultView();
        resultView.result(lottoGame.convert(inputView.getWinNumbers(), inputView.addBonusNumber()));
    }
}
