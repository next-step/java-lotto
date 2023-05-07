package lotto;

import lotto.utility.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LotteryTickets;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {
  public static void main(String[] args) {
    LotteryTickets lotteryTickets = new LotteryTickets();
    String strBudget = InputView.askBudget();
    int budget = InputConverter.convertBudgetToInt(strBudget);

    lotteryTickets.purchase(budget);
    List<Lotto> lottoBundle = lotteryTickets.getLottoBundle();

    ResultView.showMyLotto(lottoBundle);

    WinningStatistics winningStatistics = new WinningStatistics(InputConverter.convertNumberToList(InputView.askLastLottoNumber()));

    Map<Integer, Integer> resultMap = winningStatistics.lottoResult(lottoBundle);
    int totalWinningPrice = winningStatistics.sumTotalWinningPrice(resultMap);
    double roi = winningStatistics.calcRoi(totalWinningPrice, lotteryTickets.getInvestment());

    ResultView.showStatistic(resultMap);
    ResultView.showRoi(roi);


  }

}
