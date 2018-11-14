package lotto;


import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoGameResult;

import java.util.List;

import static lotto.ui.InputView.buyLotto;
import static lotto.ui.InputView.lastWeekWinnerNumbers;
import static lotto.ui.ResultView.printBuyLottoNumbers;
import static lotto.ui.ResultView.printResultLottoReword;

public class ConsoleApplication {
    public static void main(String[] args) {
        int totalPrice = buyLotto();

        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.createLotto(totalPrice);

        printBuyLottoNumbers(lottos);

        String winnerNumber = lastWeekWinnerNumbers();
        LottoGameResult rewordLotto = lottoGame.getReword(winnerNumber);
        float earningsRate = rewordLotto.earningsRate(totalPrice);
        printResultLottoReword(rewordLotto, earningsRate);

    }
}
