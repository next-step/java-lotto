package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.PurchaseLottoView;
import lotto.view.ResultView;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseLottoView purchaseLottoView = new PurchaseLottoView();

        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.initLottos(inputView.getMoney());
        purchaseLottoView.print(lottos);

        List<Rank> gameResults = lottoGame.matches(inputView.getWinningLotto(), lottos);

        ResultView resultView = new ResultView();
        resultView.print(gameResults);
    }
}
