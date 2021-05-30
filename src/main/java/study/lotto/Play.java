package study.lotto;

import study.lotto.domain.LottoGame;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;


public class Play {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoGame lottoGame = new LottoGame(inputView, resultView);
        lottoGame.play();
    }
}
