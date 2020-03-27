package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;

import java.util.Set;

public class LottoGameController {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.requestMoney());
        Set<Integer> gameResults = lottoGame.getGameResults(InputView.requestWinningNumber());
        System.out.println(gameResults.toString());
    }
}
