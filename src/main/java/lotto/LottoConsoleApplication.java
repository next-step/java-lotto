package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoConsoleApplication {
    public static void main(String[] args) {
        LottoShop shop = LottoShop.getInstance();

        int payment = InputView.inputPayment();
        Lottos lottos = shop.buy(payment);

        ResultView.printGameCount(payment);

        ResultView.printLottoNumber(lottos);

        String winningNumbers = InputView.inputWinningNumbers();
        WinningNumber winningNumber = WinningNumber.from(winningNumbers);

        List<LottoPrize> lottoPrizes = lottos.scratch(winningNumber);
        LottoStatistics lottoStatistics = LottoStatistics.from(payment, lottoPrizes);
        ResultView.printStatistic(lottoStatistics);
    }
}
