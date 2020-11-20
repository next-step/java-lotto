package lotto;

import static lotto.LottoGameConstant.MAXIMUM_REWARD_HIT;
import static lotto.LottoGameConstant.MINIMUM_REWARD_HIT;

import lotto.views.InputView;
import lotto.views.ResultView;

public class Client {

  public static void main(String[] args) {
    Budget budget = Budget.of(InputView.askBudget());
    ResultView.printNumLotto(budget.getNumPossibleLotto());

    LottoTickets purchasedTickets = budget.purchaseLotto(budget.getNumPossibleLotto());
    ResultView.printLottoInfo(purchasedTickets.toString());

    WinningNumber winningNumber = NumberPool.publishWinningNumber(InputView.askWinningNumber());
    LottoResult lottoResult = purchasedTickets.settle(winningNumber);

    ResultView.printStatisticsOpening();
    for (int hit = MINIMUM_REWARD_HIT; hit <= MAXIMUM_REWARD_HIT; hit++) {
      ResultView
          .printRewards(hit, lottoResult.getReward(hit), lottoResult.getRecordedNumberOfHit(hit));
    }

    ResultView.printIncome(budget.calculateRatio(lottoResult.calculateIncome()));
    ResultView.printDescription(budget.getDescriptiveStatus(lottoResult.calculateIncome()));
  }
}
