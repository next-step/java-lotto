package lotto;

import lotto.views.InputView;
import lotto.views.ResultView;

public class Client {

  public static void main(String[] args) {
    Budget budget = Budget.of(InputView.askBudget());
    ResultView.printNumLotto(budget.getNumPossibleLotto());

    LottoTickets purchasedTickets = budget.purchaseLotto(budget.getNumPossibleLotto());
    ResultView.printLottoInfo(purchasedTickets.toString());

    ResultView.printStatisticsOpening();

  }
}
