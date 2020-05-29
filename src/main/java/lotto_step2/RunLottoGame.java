package lotto_step2;

import lotto_step2.domain.LottoGame;
import lotto_step2.model.Lottos;
import lotto_step2.model.Prize;
import lotto_step2.view.InputView;
import lotto_step2.view.ResultView;

import java.util.List;

public class RunLottoGame {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        int money = inputView.getMoney();

        LottoGame lottoGame = new LottoGame();
        Lottos lottos = lottoGame.getBuyLottos(money);
        inputView.printBuyLotto(lottos);

        List<Prize> gameResults = lottoGame.matches(inputView.getLastWeekLotto(), lottos);

        ResultView resultView = new ResultView();
        resultView.printGameResult(gameResults);
        resultView.printRevenue(gameResults, money);
    }
}
