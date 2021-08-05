package lotto.domain;

import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

  private static final int INT_ZERO = 0;

  private final List<Lotto> lottos = new ArrayList<>();

  public Lotteries(int count, final List<Integer> numberPull) {
    createLotteries(count, numberPull);
  }

  public Lotteries() {

  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  private void createLotteries(int count,List<Integer> numberPull) {
    range(INT_ZERO, count)
        .mapToObj(i -> new Lotto(numberPull))
        .forEach(lottos::add);
  }

  public int getMatchLotteries(Lotto lotty, Lotto winLotto) {
    int count = INT_ZERO;
    for (LottoNumber lottoNumber : lotty.getLotto()) {
      count = checkContainValues(winLotto, count, lottoNumber);
    }
    return count;
  }

  private int checkContainValues(final Lotto winLotto, int count, final LottoNumber lottoNumber) {
    if (winLotto.getLotto().contains(lottoNumber)) {
      count++;
    }
    return count;
  }

  public static Lotto getWinningLotto(List<Integer> inputValues) {
    return new Lotto(inputValues);
  }
}
