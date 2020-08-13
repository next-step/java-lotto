package controller;


import domain.LottoGame;
import domain.Lottos;
import strategy.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();

        LottoGame lottoGame = new LottoGame(buyPrice);

        ResultView.viewBuyAmount(lottoGame.getBuyAmount());
        Lottos lottos = lottoGame.issue(new RandomNumberGenerator());
        ResultView.viewIssuedLotto(lottos);

        String winningNumbers = InputView.inputWinningNumber();
    }
}
