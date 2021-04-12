package lotto.domain.place;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
  FIRST(6, 2_000_000_000, (countOfMatch, matchBonus) -> countOfMatch == 6),
  SECOND(5, 30_000_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus == true),
  THIRD(5, 1_500_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus == false),
  FOURTH(4, 50_000, (countOfMatch, matchBonus) -> countOfMatch == 4),
  FIFTH(3, 5_000, (countOfMatch, matchBonus) -> countOfMatch == 3),
  MISS(0, 0, (countOfMatch, matchBonus) -> countOfMatch < 3);

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
