package controller;

import domain.LottoGame;
import view.InputView;
import view.ResultView;

public class LottoController {

    public void start(){
        InputView inputView = new InputView();
        LottoGame lottoGame = new LottoGame(inputView.getMoney());
        new ResultView(lottoGame.convert(inputView.getWinNumbers()));
    }
}
