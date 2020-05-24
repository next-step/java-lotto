package step2.domain;

import step2.exception.LottoGamePriceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoGame {

  public static final long LOTTO_PRICE = 1000;
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

  public long getWinningCount (Rank rank) {
    return stream().filter(lotto -> getEqualRankOfLotto(lotto, rank))
                   .count();
  }

  public double getPayoff () {
    long payoff = Rank.stream()
                      .map(rank -> rank.getPrice() * getWinningCount(rank))
                      .reduce(0L, Math::addExact);
    return payoff / (double)(stream().count() * LOTTO_PRICE);
  }

  public static LottoGame of (long price) {
    validatePrice(price);
    int lottoCount = (int)(price / LOTTO_PRICE);
    return Arrays.stream(new long[lottoCount])
                 .boxed()
                 .map(v -> Lotto.of())
                 .collect(collectingAndThen(toList(), LottoGame::of));
  }

  public static LottoGame of (List<Lotto> lottoList) {
    return new LottoGame(lottoList);
  }

  public boolean getEqualRankOfLotto (Lotto lotto, Rank rank) {
    long same = lotto.stream()
                     .filter(winningLotto::has)
                     .count();
    return Rank.valueOf(same).equals(rank);
  }

  public static void validatePrice (long price) throws RuntimeException {
    if (price < LOTTO_PRICE) {
      throw new LottoGamePriceException();
    }
  }
}
