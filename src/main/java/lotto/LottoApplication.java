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
    int lottoPrice = InputView.getLottoPrice();
    LottoGame lottoGame = new LottoGame(lottoPrice, new BaseKoreaLottoRaffleGenerator());
    ResultView.showLottoRounds(lottoGame.getLottoRounds());

    List<Integer> lastWeekLottoNumbers = InputView.getLastWeekLottoNumbers();
    LottoGameStatistics statistics = lottoGame.play(lastWeekLottoNumbers);
    ResultView.displayStatistics(statistics);
  }
}
