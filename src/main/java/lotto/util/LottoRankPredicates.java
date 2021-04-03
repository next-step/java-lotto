package lotto.util;

import java.util.Arrays;
import java.util.function.Predicate;
import lotto.domain.LottoRank;

public class LottoRankPredicates {

  private static final int SECOND_OR_THIRD = 5;

  private static Predicate<LottoRank> getSecondOrThird(boolean bonusBall) {
    return rank -> getSecondOrThird(bonusBall, rank);
  }

  private static Predicate<LottoRank> isSecondOrThird(int matchCount) {
    return rank -> rank.isCorrectMatchCount(matchCount);
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

  public static LottoRank filterLottoRankByName(String winnerRank) {
    return Arrays.stream(LottoRank.values())
        .filter(findRank(winnerRank))
        .findAny()
        .orElseThrow(IllegalArgumentException::new);
  }

  private static LottoRank filterLottoRankIsSecondOrThird(int matchCount, boolean bonusBall) {
    return Arrays.stream(LottoRank.values())
        .filter(isSecondOrThird(matchCount))
        .filter(getSecondOrThird(bonusBall))
        .findAny()
        .orElse(LottoRank.NONE);
  }

  private static LottoRank filterLottRankIsDefault(int matchCount) {
    return Arrays.stream(LottoRank.values())
        .filter(defaultCase(matchCount))
        .findAny()
        .orElse(LottoRank.NONE);
  }

  public static LottoRank filter(int matchCount, boolean bonusBall) {
    if(matchCount == SECOND_OR_THIRD) {
      return filterLottoRankIsSecondOrThird(matchCount, bonusBall);
    }
    return filterLottRankIsDefault(matchCount);
  }
}
