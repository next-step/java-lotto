package lotto;


import lotto.game.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new InputView(), new ResultView());
        lottoGame.run();
    }
}
