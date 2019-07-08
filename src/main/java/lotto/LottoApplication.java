package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoApplication {
    public static void main(String[] args) {
        Money money = new Money(InputView.firstQuestionAndReturnAnswer());

        LottoStore lottoStore = new LottoStore();
        List<LottoTicket> purchasedLottoTickets = lottoStore.buyLotto(money);

        ResultView.printPurchasedLottoTickets(purchasedLottoTickets);

        WinningLottoTicket winningLottoTicket = InputView.secondQuestionAndReturnAnswer();
        LottoResult lottoResult = lottoStore.match(winningLottoTicket);
        ResultView.printWinStatistics(lottoResult);
    }
}
