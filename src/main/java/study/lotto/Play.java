package study.lotto;

import study.lotto.domain.LottoGame;
import study.lotto.view.RealInputView;
import study.lotto.view.ResultView;


public class Play {


    public static void main(String[] args) {
        RealInputView realInputView = new RealInputView();
        ResultView resultView = new ResultView();
        LottoGame lottoGame = new LottoGame(realInputView, resultView);
        lottoGame.play();
    }
}
