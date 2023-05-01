package lotto2;

import lotto2.domain.LottoMachine;
import lotto2.domain.LottoTicket;
import lotto2.domain.Prize;
import java.util.List;
import java.util.Map;
import lotto2.util.StatisticalCalculator;
import lotto2.view.InputView;
import lotto2.view.ResultView;

public class Application {

  public static void main(String[] args) {
    int investMoney = InputView.scanMoney();
    LottoMachine lottoMachine = new LottoMachine();

    List<LottoTicket> lottoTickets = lottoMachine.makeLottoTickets(investMoney);
    ResultView.printLottoTickets(lottoTickets);

    List<Integer> winningNumbers = InputView.scanWinningNumbers();

    Map<Prize, Long> matchedCountMap = StatisticalCalculator.calculate(lottoTickets,
        winningNumbers);

    ResultView.printMatchedCount(matchedCountMap);

    long earnMoney = StatisticalCalculator.calculateEarnMoney(matchedCountMap);
    ResultView.printProfit(investMoney, earnMoney);
  }

}
