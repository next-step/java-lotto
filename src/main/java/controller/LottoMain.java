package controller;


import domain.LottoGame;
import strategy.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();

        LottoGame lottoGame = new LottoGame(buyPrice);

        ResultView.viewBuyAmount(lottoGame.getBuyAmount());
        ResultView.viewIssuedLotto(lottoGame.issue(new RandomNumberGenerator()));
    }
}
