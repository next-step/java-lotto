package lottoGame;

import lottoGame.model.strategy.AutoShuffleStrategy;
import lottoGame.view.InputView;
import lottoGame.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGameController lottoController = new LottoGameController(InputView.print(), new AutoShuffleStrategy(), new ResultView());
        lottoController.start();
    }
}
