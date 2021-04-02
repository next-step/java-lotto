package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public class LottoRankPredicates {

  private static Predicate<LottoRank> isSecondOrThird(boolean bonusBall) {
    return rank -> getSecondOrThird(bonusBall, rank);
  }

  private static Predicate<LottoRank> defaultCase(int matchCount) {
    return rank -> rank.isCorrectMatchCount(matchCount);
  }

  private static Predicate<LottoRank> findRank(String winnerRank) {
    return rank -> rank.name().equals(winnerRank);
  }

  private static boolean getSecondOrThird(boolean bonusBall, LottoRank rank) {
    if(bonusBall) {
      return rank == LottoRank.SECOND;
    }
    return rank == LottoRank.THIRD;
  }

  public static LottoRank filterLottoRankWithString(String winnerRank) {
    return Arrays.stream(LottoRank.values())
        .filter(findRank(winnerRank))
        .findAny()
        .orElseThrow(IllegalArgumentException::new);
  }

  public static LottoRank filterLottoRankIsSecondOrThird(boolean bonusBall) {
    return Arrays.stream(LottoRank.values())
        .filter(isSecondOrThird(bonusBall))
        .findAny()
        .orElse(LottoRank.NONE);
  }

  public static LottoRank filterLottRankIsDefault(int matchCount) {
    return Arrays.stream(LottoRank.values())
        .filter(defaultCase(matchCount))
        .findAny()
        .orElse(LottoRank.NONE);
  }
}
