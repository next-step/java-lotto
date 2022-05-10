package lotto;

import lotto.domain.LotteryShop;
import lotto.domain.LottoTickets;
import lotto.domain.Statistics;
import lotto.domain.WinNumbers;
import lotto.domain.money.Money;
import lotto.domain.strategy.RandomNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMainApplication {

  public static void main(String[] args) {
    Money amount = Money.createWon(InputView.requestPurchaseAmount());
    LotteryShop lotteryShop = new LotteryShop();
    LottoTickets lottoTickets = lotteryShop.sell(amount, new RandomNumbers());
    ResultView.printLottoCount(lottoTickets.size());
    ResultView.printLottoTickets(lottoTickets);

    WinNumbers winNumbers = new WinNumbers(InputView.requestLastWeekWinNumbers());
    Statistics statistics = new Statistics(winNumbers, lottoTickets,
        LotteryShop.PRICE_PER_PLAY_FOR_LOTTO);
    ResultView.printStatistics(statistics);
  }
}
