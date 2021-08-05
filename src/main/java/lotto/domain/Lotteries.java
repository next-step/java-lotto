package lotto.domain;

import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.GenerateLottoNumber;

public class Lotteries {

  private static final int INT_ZERO = 0;

  private List<Lotto> lotteries = new ArrayList<>();

  public Lotteries() {
  }

  public Lotteries(int count, GenerateLottoNumber generateLottoNumber) {
    createLotties(count, generateLottoNumber);
  }

  public List<Lotto> getLotteries() {
    return lotteries;
  }

  private void createLotties(int count, GenerateLottoNumber generateLottoNumber) {
    range(INT_ZERO, count).forEach(i -> lotteries.add(new Lotto(generateLottoNumber)));
  }

  public int getMatchLotteries(Lotto lotty, Lotto winLotto) {
    int count = INT_ZERO;
    for (LottoNumber lottoNumber : lotty.getLotto()) {
      if (winLotto.getLotto().contains(lottoNumber)) {
        count++;
      }
    }
    return count;
  }

  public static Lotto getWinningLotto(String[] inputValues) {
    return new Lotto(inputValues);
  }
}
