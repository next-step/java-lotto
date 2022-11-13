package nextstep.lotto;

import java.util.List;
import nextstep.lotto.domain.Lotto;
import nextstep.lotto.domain.LottoGame;
import nextstep.lotto.domain.LottoGameFactory;
import nextstep.lotto.domain.LottoRandomGenerator;
import nextstep.lotto.domain.LottoSummary;
import nextstep.lotto.view.InputView;
import nextstep.lotto.view.ResultView;

public class LottoSimulationGame {
  private final InputView inputView;
  private final ResultView resultView;

  private final LottoGameFactory lottoGameFactory;

  public LottoSimulationGame(final InputView inputView, final ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
    this.lottoGameFactory = new LottoGameFactory(new LottoRandomGenerator());
  }

  public void run() {
    final int cost = inputView.inputCost();
    final List<Lotto> lottos = this.lottoGameFactory.random(cost);
    resultView.writeLottos(lottos);

    final String winningNumbers = inputView.inputWinningNumbers();

    final LottoGame lottoGame = new LottoGame(winningNumbers);
    final LottoSummary lottoSummary = new LottoSummary(1000,lottoGame.match(lottos));
    resultView.writeSummary(lottoSummary);
  }
}
