package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;

import lotto.model.Lottos;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LottoGame lottoGame = new LottoGame();
        int money = inputView.getMoney();
        Lottos lottos = lottoGame.initLottos(money);
        resultView.printPurchasedLotto(lottos);

        List<Result> gameResults = lottoGame.matches(inputView.getWinningLotto(), inputView.getBonusNumber(), lottos);

        resultView.printGameResult(gameResults);
        resultView.printRevenue(gameResults, money);
    }
}
