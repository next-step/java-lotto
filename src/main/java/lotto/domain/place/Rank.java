package lotto.domain.place;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank implements BaseRank {
  FIRST(FIRST_COUNT_OF_MATCH, 2_000_000_000, (countOfMatch, matchBonus) -> countOfMatch == FIRST_COUNT_OF_MATCH),
  SECOND(SECOND_COUNT_OF_MATCH, 30_000_000, (countOfMatch, matchBonus) -> countOfMatch == SECOND_COUNT_OF_MATCH && matchBonus == true),
  THIRD(THIRD_COUNT_OF_MATCH, 1_500_000, (countOfMatch, matchBonus) -> countOfMatch == THIRD_COUNT_OF_MATCH && matchBonus == false),
  FOURTH(FOURTH_COUNT_OF_MATCH, 50_000, (countOfMatch, matchBonus) -> countOfMatch == FOURTH_COUNT_OF_MATCH),
  FIFTH(FIFTH_COUNT_OF_MATCH, 5_000, (countOfMatch, matchBonus) -> countOfMatch == FIFTH_COUNT_OF_MATCH),
  MISS(0, 0, (countOfMatch, matchBonus) -> countOfMatch < FIFTH_COUNT_OF_MATCH);

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

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }


}
