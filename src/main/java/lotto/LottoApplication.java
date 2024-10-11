package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResults;
import lotto.view.ResultView;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        int price = inputInt(ResultView::printInputPrice);
        LottoGame lottoGame = new LottoGame(price);
        printLottoGames(lottoGame);
        Lotto winningLotto = new Lotto(inputLotto(ResultView::printLastWeekLotto));

        LottoResults lottoResults = lottoGame.makeLottoResult(winningLotto);
        printResults(lottoResults);
        printRatio(lottoGame.getEarnRate());
    }
}
