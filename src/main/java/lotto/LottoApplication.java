package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    LottoTickets lottoTickets = LottoTickets.of(inputView.readPrice());
    resultView.printLottos(lottoTickets);

    LottoStatistics statistics = lottoTickets.createWinningStatistics(new Lotto(inputView.readWinningNumbers()),
        inputView.readBonusBall());

    resultView.printWinningStatistics(statistics.getRankCounts(), statistics.calculateProfitRate());
  }
}
