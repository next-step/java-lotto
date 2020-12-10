package autolotto.controller;

import autolotto.model.*;
import autolotto.view.InputView;
import autolotto.view.LottoVeiw;
import autolotto.view.ResultView;

public class LottoController {

    public static void playLotto() {
        int purchaseAmount = InputView.inputMoney();
        Buyer buyer = new Buyer(purchaseAmount);

        buyer.buyLottos();
        LottoVeiw.viewLottos(buyer.getLottos());

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        LottosComparer lottosComparer = new LottosComparer(buyer.getLottos(), winningNumbers.getNumbers());

        ResultView.viewStatistic(lottosComparer);
        float profitRate = ProfitCalculator.calculate(purchaseAmount, lottosComparer);
        ResultView.viewProfitRate(profitRate);

    }
}
