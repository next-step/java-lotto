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
    LottoTickets lottoTickets = lotteryShop.sell(amount, new RandomNumbers(), manualLottoNumbers);
    ResultView.printLottoCount(lottoTickets.randomLottoCount());
    ResultView.printLottoTickets(lottoTickets);

    String inputWinningLottoNumbers = InputView.requestLastWeekWinNumbers();
    String bonusBallNumber = InputView.requestBonusBallNumber();
    WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(inputWinningLottoNumbers,
        bonusBallNumber);
    StatisticInfo statisticInfo = StatisticInfo.of(winningLottoTicket, lottoTickets,
        LotteryShop.PRICE_PER_PLAY_FOR_LOTTO);
    ResultView.printStatistics(statisticInfo);
  }
}
