package lotto;


import lotto.model.Lotto;
import lotto.model.LottoGame;

import java.util.List;
import java.util.Map;

import static lotto.model.LottoGameResult.earningsRate;
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
        Map<Integer, Integer> rewordLotto = lottoGame.getReword(winnerNumber);
        float earningsRate = earningsRate(rewordLotto, totalPrice);
        printResultLottoReword(rewordLotto, earningsRate);


    }
}
