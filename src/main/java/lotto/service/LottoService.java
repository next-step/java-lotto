package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoService {

  private final InputView inputView;
  private final ResultView resultView;

  public LottoService(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public void run() {
    LottoTickets lottoTickets = createLottoTickets();
    resultView.printLottos(lottoTickets);

    LottoStatistics statistics = calculateWinningStatistics(lottoTickets);
    resultView.printWinningStatistics(statistics.getRankCounts(), statistics.calculateProfitRate());
  }

  private LottoTickets createLottoTickets() {
    int price = inputView.readPrice();
    int manualLottoCount = inputView.readManualLottoCount();
    List<Lotto> manualLottos = inputView.readManualLottoNumbers(manualLottoCount)
        .stream()
        .map(Lotto::new)
        .collect(Collectors.toList());

    LottoTickets lottoTickets = LottoTickets.of(manualLottos, price);
    resultView.printLottoCount(manualLottoCount, lottoTickets.size() - manualLottoCount);
    return lottoTickets;
  }

  private LottoStatistics calculateWinningStatistics(LottoTickets lottoTickets) {
    return lottoTickets.createWinningStatistics(new Lotto(inputView.readWinningNumbers()), inputView.readBonusBall());
  }
} 