package lotto;

import java.io.IOException;
import java.util.List;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.raffle.BaseKoreaLottoRaffleGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main (String[] args) throws IOException {
    InputView inputView = new InputView();

    int lottoPrice = inputView.getLottoPrice();
    LottoGame lottoGame = new LottoGame(lottoPrice, new BaseKoreaLottoRaffleGenerator());
    ResultView.showLottoRounds(lottoGame.getLottoRounds());

    List<Integer> lastWeekLottoNumbers = inputView.getLastWeekLottoNumbers();
    LottoGameStatistics statistics = lottoGame.play(lastWeekLottoNumbers);
    ResultView.displayStatistics(statistics);

    inputView.tearDown();
  }
}
