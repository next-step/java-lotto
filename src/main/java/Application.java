import domain.LottoMachine;
import domain.LottoTicket;
import domain.Prize;
import domain.RandomNumberGenerator;
import java.util.List;
import java.util.Map;
import util.StatisticalCalculator;
import view.InputView;
import view.ResultView;

public class Application {

  public static void main(String[] args) {
    int investMoney = InputView.scanMoney();
    LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

    List<LottoTicket> lottoTickets = lottoMachine.makeLottoTickets(investMoney);
    ResultView.printLottoTickets(lottoTickets);

    List<Integer> winningNumbers = InputView.scanWinningNumbers();

    Map<Prize, Integer> matchedCountMap = StatisticalCalculator.calculate(lottoTickets,
        winningNumbers);

    ResultView.printMatchedCount(matchedCountMap);

    int earnMoney = StatisticalCalculator.calculateEarnMoney(matchedCountMap);
    ResultView.printProfit(investMoney, earnMoney);
  }

}
