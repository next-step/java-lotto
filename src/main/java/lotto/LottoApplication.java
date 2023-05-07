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

    List<Integer> targetNumber = InputConverter.convertNumberToList(InputView.askLastLottoNumber());
    int bonusNumber = InputConverter.convertBonusNumber(targetNumber, InputView.askBonusNumber());
    WinningStatistics winningStatistics = new WinningStatistics(targetNumber, bonusNumber);

    Map<Integer, Integer> resultMap = winningStatistics.lottoResult(lottoBundle);
    int totalWinningPrice = winningStatistics.showTotalWinningPrice();
    double roi = winningStatistics.calcRoi(totalWinningPrice, lottoBundle.size()*Lotto.PRICE);

    ResultView.showStatistic(resultMap);
    ResultView.showRoi(roi);


  }

}
