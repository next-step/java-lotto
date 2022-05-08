package lotto;

import java.util.List;
import lotto.domain.LotteryRetailer;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMainApplication {

  public static void main(String[] args) {
    Money amount = Money.of(InputView.requestPurchaseAmount());
    LotteryRetailer lotteryRetailer = new LotteryRetailer();
    List<LottoTicket> lottoTickets = lotteryRetailer.sell(amount, new LottoNumberGenerator());
    ResultView.printLottoCount(lottoTickets.size());
    ResultView.printLottoTickets(lottoTickets);

    WinNumbers winNumbers = new WinNumbers(InputView.requestLastWeekWinNumbers());
    //    Statistics statistics = new Statistics(winNumbers, lottoTickets);
    //    ResultView.printStatistics(statistics);
  }
}
