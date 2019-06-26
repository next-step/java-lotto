package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.firstQuestionAndReturnAnswer();

        LottoStore lottoStore = new LottoStore();
        LottoTickets purchasedLottoTickets = lottoStore.buyLotto(money);

        ResultView.printPurchasedLottoTickets(purchasedLottoTickets);

        WinningNumbers winningNumbers = InputView.secondQuestionAndReturnAnswer();
        LottoResult lottoResult = purchasedLottoTickets.match(winningNumbers);
        ResultView.printWinStatistics(lottoResult);
    }
}
