package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.PurchaseLottoView;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseLottoView purchaseLottoView = new PurchaseLottoView();

        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.initLottos(inputView.getMoney());
        purchaseLottoView.print(lottos);


//        inputView.getWinningLotto();
    }
}
