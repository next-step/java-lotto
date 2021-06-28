package lottogame.controller;

import lottogame.service.LottoGame;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGame lottoGame = new LottoGame();

        int buyCount = lottoGame.getBuyCount(inputView.inputBuyPrice());

    }
}
