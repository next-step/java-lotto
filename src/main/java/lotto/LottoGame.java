package lotto;

import java.util.List;
import java.util.Map;
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

    LottoTickets tickets = LottoTickets.issue(lottoPurchasablePrice.ticketPurchasableNumber(), LottoNumbersRandomSelector.getInstance());
    resultView.showTicketsInfo(tickets);

    List<LottoNumber> lastWeekNumbers = inputView.lastWeekNumbers();
    LottoNumber bonusNumber = inputView.bonusNumber();
    validateLastWeekNumbersHasBonusNumber(lastWeekNumbers, bonusNumber);

    Map<Winning, Integer> winnings = tickets.score(lastWeekNumbers, bonusNumber);
    double profit = Winning.profit(winnings, lottoPurchasablePrice);
    resultView.printResult(winnings, profit);
  }

  private void validateLastWeekNumbersHasBonusNumber(List<LottoNumber> lastWeekNumbers, LottoNumber bonusNumber) {
    if (lastWeekNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 숫자는 이전 주 당첨 번호와 중복될 수 없습니다.");
    }
  }
}
