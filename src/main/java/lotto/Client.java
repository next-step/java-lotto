package lotto;

import lotto.views.InputView;
import lotto.views.ResultView;
import lotto.views.StatisticsExporter;
import lotto.views.TicketsExporter;

public class Client {

  public static void main(String[] args) {
    Budget budget = Budget.of(InputView.askBudget());
    ResultView.printNumLotto(budget.getNumPossibleLotto());

    LottoTickets purchasedTickets = TicketPublisher.publishTickets(budget);
    TicketsExporter ticketsExporter = new TicketsExporter(purchasedTickets);
    ResultView.printLottoInfo(ticketsExporter);

    WinningNumber winningNumber =
        WinningNumber.of(LottoNumberBundle.of(InputView.askWinningNumber()));

    LottoNumber bonusNumber = LottoNumber.of(InputView.askBonusNumber());
    winningNumber.validateBonusNumberDuplication(bonusNumber);

    LottoResult lottoResult = purchasedTickets.settle(winningNumber, bonusNumber);

    ResultView.printStatisticsOpening();
    StatisticsExporter statisticsExporter = new StatisticsExporter(lottoResult.exportData());
    ResultView.printRewards(statisticsExporter);

    ResultView.printIncome(budget.calculateRatio(lottoResult.calculateIncome()));
    ResultView.printDescription(budget.getDescriptiveStatus(lottoResult.calculateIncome()));
  }
}
