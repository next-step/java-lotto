package step2.domain;

import step2.exception.LottoGamePriceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

  private final List<Lotto> lottoList;
  private Lotto winningLotto;

  private LottoGame(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public Stream<Lotto> stream () {
    return lottoList.stream();
  }

  public void setWinningNumber (Lotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public long getWinningCount (int same) {
    return stream().filter(lotto -> getSames(lotto, winningLotto) == same).count();
  }

  public double getPayoff () {
    long payoff = WinningPrice.stream()
                              .map(v -> v.getPrice() * getWinningCount(v.getSame()))
                              .reduce(0L, Math::addExact);
    return payoff / (double) (stream().count() * 1000);
  }

  public static LottoGame of (int price) {
    validatePrice(price);
    return new LottoGame(Arrays.stream(new int[price / 1000])
                               .boxed()
                               .map(v -> Lotto.of())
                               .collect(Collectors.toList()));
  }

  public static LottoGame of (List<Lotto> lottoList) {
    return new LottoGame(lottoList);
  }

  public static long getSames (Lotto lotto1, Lotto lotto2) {
    List<Integer> numbers = lotto2.stream().collect(Collectors.toList());
    return lotto1.stream().filter(numbers::contains).count();
  }

  public static void validatePrice (int price) throws RuntimeException {
    if (price < 1000) {
      throw new LottoGamePriceException();
    }
  }
}
