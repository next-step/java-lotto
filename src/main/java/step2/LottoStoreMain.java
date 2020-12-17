package step2;

import step2.domain.LottoGame;
import step2.domain.Request;
import step2.view.InputView;

import static step2.view.ResultView.*;

public class LottoStoreMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Request request = inputView.putPurchaseMoney();

        LottoGame lottoGame = new LottoGame(request);
        printLotto(lottoGame.getLotto(), ", ");

        printWinLotto(lottoGame, inputView.putTargetNumber(), request);
    }
}
