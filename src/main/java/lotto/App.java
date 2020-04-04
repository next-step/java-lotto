package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.PurchaseLottoView;
import lotto.view.ResultView;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseLottoView purchaseLottoView = new PurchaseLottoView();

        LottoGame lottoGame = new LottoGame();
        int money = inputView.getMoney();
        List<Lotto> lottos = lottoGame.initLottos(money);
        purchaseLottoView.print(lottos);

        List<Result> gameResults = lottoGame.matches(inputView.getWinningLotto(), lottos);

        ResultView resultView = new ResultView();
        resultView.print(gameResults);
        resultView.printRevenue(gameResults, money);
    }
}
