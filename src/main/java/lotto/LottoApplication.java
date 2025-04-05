package lotto;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.PrizeRank;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    LottoTickets lottoTickets = LottoTickets.of(inputView.readPrice());
    resultView.printLottos(lottoTickets);

    Lotto winningNumbers = new Lotto(inputView.readWinningNumbers());
    int bonusBall = inputView.readBonusBall();
    Map<PrizeRank, Integer> statistics = lottoTickets.calculateWinningStatistics(winningNumbers, bonusBall);
    double profitRate = lottoTickets.calculateProfitRate(statistics);

    resultView.printWinningStatistics(statistics, profitRate);
  }
}
