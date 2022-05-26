package lotto;

import java.util.List;
import lotto.domain.LotteryShop;
import lotto.domain.LottoTickets;
import lotto.domain.StatisticInfo;
import lotto.domain.WinningLottoTicket;
import lotto.domain.money.Money;
import lotto.domain.strategy.RandomNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMainApplication {

  public static void main(String[] args) {
    Money amount = Money.createWon(InputView.requestPurchaseAmount());
    int manualPurchaseLotto = InputView.requestManualPurchaseLotto();
    List<String> manualLottoNumbers = InputView.requestManualLottoNumber(manualPurchaseLotto);
    LotteryShop lotteryShop = new LotteryShop();
    LottoTickets lottoTickets;
    try {
      lottoTickets = lotteryShop.sell(amount, new RandomNumbers(), manualLottoNumbers);
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return;
    }

    ResultView.printLottoCount(lottoTickets.manualLottoCount(), lottoTickets.randomLottoCount());
    ResultView.printLottoTickets(lottoTickets);

    String inputWinningLottoNumbers = InputView.requestLastWeekWinNumbers();
    String bonusBallNumber = InputView.requestBonusBallNumber();
    WinningLottoTicket winningLottoTicket;
    try {
      winningLottoTicket = WinningLottoTicket.of(inputWinningLottoNumbers, bonusBallNumber);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      return;
    }

    StatisticInfo statisticInfo = StatisticInfo.of(winningLottoTicket, lottoTickets,
        LotteryShop.PRICE_PER_PLAY_FOR_LOTTO);
    ResultView.printStatistics(statisticInfo);
  }
}
