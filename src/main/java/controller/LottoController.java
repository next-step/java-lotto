package controller;

import domain.LottoGame;
import view.InputView;
import view.ResultView;

public class LottoController {

    public static void main(String[] args){
        InputView inputView = new InputView();
        LottoGame lottoStore = new LottoGame(inputView.getMonkey(), inputView.getWinNumbers());

        ResultView resultView = new ResultView(lottoStore.convert());
    }
}
