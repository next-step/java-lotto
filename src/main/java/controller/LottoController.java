package controller;

import domain.LottoGame;
import view.InputView;
import view.ResultView;

public class LottoController {

    public static void main(String[] args){
        InputView inputView = new InputView();
        LottoGame lottoGame = new LottoGame(inputView.getMoney(), inputView.getWinNumbers());


//        ResultView resultView = new ResultView(lottoStore.convert());
    }
}
