package autolotto.controller;

import autolotto.model.*;
import autolotto.view.InputView;
import autolotto.view.LottoVeiw;
import autolotto.view.ResultView;

public class LottoController {

    public static void playLotto() {
        int purchaseAmount = InputView.inputMoney();
        Buyer buyer = new Buyer(purchaseAmount);

        Lottos lottos = buyer.buyLottos();
        LottoVeiw.viewLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        MatchingNumbers matchingNumbers = new MatchingNumbers();
        lottos.matchLotto(winningNumbers.getNumbers(), matchingNumbers);

        ResultView.viewStatistic(matchingNumbers);
        float profitRate = ProfitCalculator.calculate(purchaseAmount, matchingNumbers);
        ResultView.viewProfitRate(profitRate);

    }
}
