import domain.LottoMachine;
import domain.RandomNumberGenerator;
import java.util.List;
import java.util.Map;
import util.StatisticalCalculator;
import view.InputView;
import view.ResultView;

public class Application {

  public static void main(String[] args) {
    int investMoney = InputView.scanMoney();
    LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator(), investMoney);

    ResultView.printLottoTickets(lottoMachine.lottoTickets());

    List<Integer> winningNumbers = InputView.scanWinningNumbers();

    Map<Integer, Integer> matchedCountMap = StatisticalCalculator.calculate(lottoMachine.lottoTickets(),
        winningNumbers);
    ResultView.printMatchedCount(matchedCountMap);

    int earnMoney = StatisticalCalculator.calculateEarnMoney(matchedCountMap);
    ResultView.printProfit(investMoney, earnMoney);
  }

}
