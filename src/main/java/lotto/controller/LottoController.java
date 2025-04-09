package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

  private final LottoService lottoService;
  private final InputView inputView;
  private final ResultView resultView;

  public LottoController(LottoService lottoService, InputView inputView, ResultView resultView) {
    this.lottoService = lottoService;
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
    List<List<Integer>> manualLottoNumbers = inputView.readManualLottoNumbers(manualLottoCount);

    List<Lotto> manualLottos = manualLottoNumbers.stream()
        .map(Lotto::new)
        .collect(Collectors.toList());

    LottoTickets lottoTickets = lottoService.createLottoTickets(price, manualLottos);
    resultView.printLottoCount(manualLottoCount, lottoTickets.size() - manualLottoCount);
    return lottoTickets;
  }

  private LottoStatistics calculateWinningStatistics(LottoTickets lottoTickets) {
    List<Integer> winningNumbers = inputView.readWinningNumbers();
    int bonusBall = inputView.readBonusBall();
    return lottoService.calculateWinningStatistics(lottoTickets, winningNumbers, bonusBall);
  }
} 