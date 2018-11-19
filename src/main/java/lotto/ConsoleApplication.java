package lotto;


import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoGameResult;
import lotto.model.Money;

import java.util.List;

import static lotto.ui.InputView.*;
import static lotto.ui.ResultView.printBuyLottoNumbers;
import static lotto.ui.ResultView.printBuyLottos;
import static lotto.ui.ResultView.printResultLottoReword;

public class ConsoleApplication {
    public static void main(String[] args) {
        int totalPrice = buyLotto();
        Money money = new Money(totalPrice);

        LottoGame lottoGame = new LottoGame();

        int manualLottoCount = buyManualLottoCount();
        String manualNumbers = manualLottoNumbers(manualLottoCount);

        List<Lotto> lottos = lottoGame.createLotto(money, manualNumbers);

        printBuyLottos(manualLottoCount, money.buyLotto() - manualLottoCount);
        printBuyLottoNumbers(lottos);

        String winnerNumber = lastWeekWinnerNumbers();
        int bonusNumber = bonusNumber();

        LottoGameResult rewordLotto = lottoGame.getReword(winnerNumber, bonusNumber);
        float earningsRate = rewordLotto.earningsRate(money);
        printResultLottoReword(rewordLotto, earningsRate);

    }
}
