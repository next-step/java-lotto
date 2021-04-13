package lotto.domain.place;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
  FIRST(Rank.FIRST_COUNT_OF_MATCH, 2_000_000_000, (countOfMatch, matchBonus) -> countOfMatch == Rank.FIRST_COUNT_OF_MATCH),
  SECOND(Rank.SECOND_COUNT_OF_MATCH, 30_000_000, (countOfMatch, matchBonus) -> countOfMatch == Rank.SECOND_COUNT_OF_MATCH && matchBonus),
  THIRD(Rank.THIRD_COUNT_OF_MATCH, 1_500_000, (countOfMatch, matchBonus) -> countOfMatch == Rank.THIRD_COUNT_OF_MATCH && !matchBonus),
  FOURTH(Rank.FOURTH_COUNT_OF_MATCH, 50_000, (countOfMatch, matchBonus) -> countOfMatch == Rank.FOURTH_COUNT_OF_MATCH),
  FIFTH(Rank.FIFTH_COUNT_OF_MATCH, 5_000, (countOfMatch, matchBonus) -> countOfMatch == Rank.FIFTH_COUNT_OF_MATCH),
  MISS(0, 0, (countOfMatch, matchBonus) -> countOfMatch < Rank.FIFTH_COUNT_OF_MATCH);

  public static final int FIRST_COUNT_OF_MATCH = 6;
  public static final int SECOND_COUNT_OF_MATCH = 5;
  public static final int THIRD_COUNT_OF_MATCH = 5;
  public static final int FOURTH_COUNT_OF_MATCH = 4;
  public static final int FIFTH_COUNT_OF_MATCH = 3;

  private final int countOfMatch;
  private final int winningMoney;
  private final BiPredicate<Integer, Boolean> matchedConditional;

  Rank(int countOfMatch, int winningMoney, BiPredicate<Integer, Boolean> matchedConditional) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
    this.matchedConditional = matchedConditional;
  }

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    return Arrays.stream(Rank.values())
            .filter(rank -> rank.matchedConditional.test(countOfMatch, matchBonus))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("입력 값이 맞지 않습니다."));
  }

  int getCountOfMatch() {
    return countOfMatch;
  }

  int getWinningMoney() {
    return winningMoney;
  }
}
