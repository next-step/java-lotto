package lotto;

import lotto.model.LottoShop;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoConsoleApplication {
    public static void main(String[] args) {
        LottoShop shop = LottoShop.getInstance();

        int payment = InputView.inputPayment();
        Lottos lottos = shop.buy(payment);

        ResultView.printGameCount(payment);

        ResultView.printLottoNumber(lottos);

        String winningNumbers = InputView.inputWinningNumbers();
        WinningNumber winningNumber = WinningNumber.from(winningNumbers);

        Lottos scratchLottos = lottos.scratch(winningNumber);
        LottoStatistics lottoStatistics = LottoStatistics.from(payment, scratchLottos);
        ResultView.printStatistic(lottoStatistics);
    }
}
