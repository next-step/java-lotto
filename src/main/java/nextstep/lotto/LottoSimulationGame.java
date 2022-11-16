package nextstep.lotto;

import java.util.List;
import java.util.Set;
import nextstep.lotto.domain.Lotto;
import nextstep.lotto.domain.LottoGame;
import nextstep.lotto.domain.LottoGameFactory;
import nextstep.lotto.domain.LottoNumber;
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
    final List<Lotto> lottos = this.lottoGameFactory.createAuto(cost);
    resultView.writeLottos(lottos);

    final Set<LottoNumber> winningNumbers = inputView.inputWinningNumbers();
    final LottoNumber bonusNumber = inputView.inputBonusNumber();

    final LottoGame lottoGame =  new LottoGame(winningNumbers, bonusNumber);
    final LottoSummary lottoSummary = new LottoSummary(1000,lottoGame.match(lottos));
    resultView.writeSummary(lottoSummary);
  }
}
