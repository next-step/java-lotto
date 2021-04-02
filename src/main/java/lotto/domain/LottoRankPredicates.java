package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public class LottoRankPredicates {

  public static Predicate<LottoRank> getSecondOrThird(boolean bonusBall) {
    return rank -> getSecondOrThird(bonusBall, rank);
  }

  public static Predicate<LottoRank> defaultCase(int matchCount) {
    return rank -> rank.getMatchCount() == matchCount;
  }

  private static boolean getSecondOrThird(boolean bonusBall, LottoRank rank) {
    if(bonusBall) {
      return rank.getWinnerMoney().equals(LottoRank.SECOND.getWinnerMoney());
    }
    return rank.getWinnerMoney().equals(LottoRank.THIRD.getWinnerMoney());
  }

  public static LottoRank filterLottoRankIsSecondOrThird(boolean bonusBall) {
    return Arrays.stream(LottoRank.values())
        .filter(getSecondOrThird(bonusBall))
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
