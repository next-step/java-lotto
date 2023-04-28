package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.raffle.BaseKoreaLottoRaffleGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int lottoPrice = InputView.getLottoPrice(bufferedReader);
    LottoGame lottoGame = new LottoGame(lottoPrice, new BaseKoreaLottoRaffleGenerator());
    ResultView.showLottoRounds(lottoGame.getLottoRounds());

    Set<Integer> lastWeekLottoNumbers = InputView.getLastWeekLottoNumbers(bufferedReader);
    LottoGameStatistics statistics = lottoGame.play(lastWeekLottoNumbers);
    ResultView.displayStatistics(statistics);
  }
}
