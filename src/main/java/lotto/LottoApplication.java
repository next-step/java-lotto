package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResults;
import lotto.domain.WinningLotto;
import lotto.view.ResultView;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        int price = inputInt(ResultView::printInputPrice);
        LottoGame lottoGame = new LottoGame(price);
        printLottoGames(lottoGame);
        WinningLotto winningLotto = new WinningLotto(new Lotto(inputLotto(ResultView::printLastWeekLotto)),
                inputInt(ResultView::printInputBonusNumber));
        LottoResults lottoResults = lottoGame.makeLottoResult(winningLotto);
        printResults(lottoResults);
        printRatio(lottoGame.getEarnRate());
    }
}
