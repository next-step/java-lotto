package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbersRandomSelector;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Winning;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGame {
  private final InputView inputView = new InputView();
  private final ResultView resultView = new ResultView();

  public void play() {
    Money userMoney = inputView.buy();
    Money lottoPurchasablePrice = Money.toLottoPurchasablePrice(userMoney);
    resultView.printChange(userMoney.subtraction(lottoPurchasablePrice));
    resultView.printPurchaseAmount(lottoPurchasablePrice.ticketPurchasableNumber());

    LottoTickets tickets = LottoTickets.issue(lottoPurchasablePrice.ticketPurchasableNumber(), new LottoNumbersRandomSelector());
    resultView.showTicketsInfo(tickets);

    List<LottoNumber> lastWeekNumbers = inputView.lastWeekNumbers();
    BonusNumber bonusNumber = inputView.bonusNumber();
    bonusNumber.validateLastWeekDuplicate(lastWeekNumbers);

    Map<Winning, Integer> winnings = Winning.score(tickets, lastWeekNumbers, bonusNumber.lottoNumber());
    double profit = Winning.profit(winnings, lottoPurchasablePrice);
    resultView.printResult(winnings, profit);
  }
}
