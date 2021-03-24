package lotto;

import lotto.service.LottoGame;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args){
        LottoGame lottoGame = new LottoGame(InputView.payLotto());
        lottoGame.start();
    }
}
