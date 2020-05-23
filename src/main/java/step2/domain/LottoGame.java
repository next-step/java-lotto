package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

  private final List<Lotto> lottoList;
  private Lotto winningLotto;

  private LottoGame(int price) {
    this.lottoList = Arrays.stream(new int[price / 1000])
                           .boxed()
                           .map(v -> Lotto.of())
                           .collect(Collectors.toList());
  }

  public Stream<Lotto> stream () {
    return this.lottoList.stream();
  }

  public void setWinningNumber (Lotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public long getWinningCount (int same) {
    return this.stream().filter(lotto -> Lotto.getSames(lotto, winningLotto) == same).count();
  }

  public static LottoGame of (int price) {
    return new LottoGame(price);
  }
}
