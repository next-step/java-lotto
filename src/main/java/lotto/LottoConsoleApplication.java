package lotto;

import lotto.model.LottoShop;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.prize.LottoPrize;
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
        String bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.from(winningNumbers, bonusNumber);

        List<LottoPrize> lottoPrizes = winningLotto.matchResults(lottos);
        LottoStatistics lottoStatistics = LottoStatistics.from(payment, lottoPrizes);
        ResultView.printStatistic(lottoStatistics);
    }
}
