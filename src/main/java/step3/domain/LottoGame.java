package step3.domain;

import step3.execption.LottoGamePriceException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

  private final List<Lotto> lottoList;
  private Lotto winningLotto;
  private int bonusNumber;

  private LottoGame(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public Stream<Lotto> stream () {
    return lottoList.stream();
  }

  public void setWinningNumber (Lotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public void setBonusNumber (int bonusNumber) {
    this.bonusNumber = bonusNumber;
  }

  public long getRankCountOf (Rank rank) {
    return stream().filter(lotto -> getLottoRank(lotto).equals(rank)).count();
  }

  public double getPayoffRatio () {
    final Function<Rank, Long> mapper = rank -> rank.getPrice() * getRankCountOf(rank);
    final long payoff = Rank.stream().map(mapper).reduce(0L, Math::addExact);
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

  public Rank getLottoRank (Lotto lotto) {
    List<Integer> winningNumbers = winningLotto.stream().collect(Collectors.toList());
    long same = lotto.stream().filter(winningNumbers::contains).count();
    boolean matchBonus = lotto.hasBonus(bonusNumber);
    return Rank.valueOf(same, matchBonus);
  }

  public static void validatePrice (int price) throws RuntimeException {
    if (price < 1000) {
      throw new LottoGamePriceException();
    }
  }
}
