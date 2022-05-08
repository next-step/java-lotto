package lotto;

import lotto.domain.LotteryRetailer;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.domain.WinNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMainApplication {

  public static void main(String[] args) {
    Money amount = Money.of(InputView.requestPurchaseAmount());
    LotteryRetailer lotteryRetailer = new LotteryRetailer();
    LottoTickets lottoTickets = lotteryRetailer.sell(amount, new LottoNumberGenerator());
    ResultView.printLottoCount(lottoTickets.size());
    ResultView.printLottoTickets(lottoTickets);

    WinNumbers winNumbers = new WinNumbers(InputView.requestLastWeekWinNumbers());
    Statistics statistics = new Statistics(winNumbers, lottoTickets,
        LotteryRetailer.PRICE_PER_PLAY_FOR_LOTTO);
    ResultView.printStatistics(statistics);
  }
}
