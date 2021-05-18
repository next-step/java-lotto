package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoAutomaticMain {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    static LottoGame lottoGame = new LottoGame();
    public static void main(String[] args) {

        resultView.resultBuyPrice(lottoGame.getBuyCount(inputView.inputBuyPrice()));
    }
}
