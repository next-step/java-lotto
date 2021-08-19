package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoWins {

  private LottoWin lottoWin;
  private List<String> lottowinningNumbers;

  public LottoWins(String[] lottowinningNumbers) {
    this.lottowinningNumbers = new ArrayList(Arrays.asList(lottowinningNumbers));
    lottoWin = new LottoWin();
  }

  public void drawLotto(Lottos lottos) {
    for (int i = 0; i < lottos.getLottosSize(); i++) {
      countWinNumber(lottos.getLotto(i));
    }
  }

  private void countWinNumber(Lotto lotto) {
    for (String lottoNumStr : lottowinningNumbers) {
      countUpWinRank(lotto, lottoNumStr);
    }
  }

  private void countUpWinRank(Lotto lotto, String lottoNumStr) {
    if (lotto.getLottoNumbers().contains(lottoNumStr)) {
      lotto.countUpWinRank();
    }
  }

  public LottoWin getLottoWin(Lottos lottos) {
    lottos.calculateWinner(lottoWin);
    return lottoWin;
  }
}
