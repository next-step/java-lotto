package lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public enum Rank {

  THREE(3, 5_000)
  , FOUR(4, 50_000)
  , FIVE(5, 1_500_000)
  , BONUS(5, 30_000_000)
  , ALL(6, 2_000_000_000)
  , NO_MATCH(0, 0);
  private final int matchCount;
  private final double price;

  Rank(int matchCount, double price) {
    this.matchCount = matchCount;
    this.price = price;
  }

  public double calculatePrice(double count) {
    return price * count;
  }

  public static Rank valueOf(int matchCount) {
    return Arrays.stream(values())
                .filter(it -> it.matchCount == matchCount)
                .findFirst()
                .orElse(Rank.NO_MATCH);
  }

  public static Rank valueOf(int matchCount, boolean hasMatchBonus) {
    Rank rank = valueOf(matchCount);
    if (BONUS.matchCount(matchCount)) {
      return hasMatchBonus ? BONUS : FIVE;
    }
    return rank;
  }

  private boolean matchCount(int matchCount) {
    return this.matchCount == matchCount;
  }

  public Lottos result(List<Lotto> lottos, Lotto resultLotto, LottoNumber bonusNumber) {
    List<Lotto> list = lottos.stream()
        .filter(lotto -> valueOf(resultLotto.matchNumberCount(lotto),lotto.has(bonusNumber))== this)
        .collect(Collectors.toList());
    return Lottos.of(list);
  }

  public Lottos result(Lottos lottos, WinningLotto winningLotto) {
    return lottos.result(winningLotto, this);
  }


  public String resultMessage(int size) {
    if (this == Rank.BONUS) {
      return String.format("%s개 일치, 보너스 볼 일치(%s원)- %s개", matchCount, (int) price, size);
    }
    return String.format("%s개 일치 (%s원)- %s개", matchCount, (int) price, size);
  }
}
