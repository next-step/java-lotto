package controller;


import domain.LottoGame;
import view.InputView;
import view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();

        LottoGame lottoGame = new LottoGame(buyPrice);
        ResultView.viewBuyAmount(lottoGame.getBuyAmount());
    }
}
