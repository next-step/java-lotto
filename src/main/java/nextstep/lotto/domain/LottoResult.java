package nextstep.lotto.domain;

import java.util.Arrays;
import java.util.Set;

public enum LottoResult {
  FIRST_PLACE(1, 2000000000, 6, Set.of(true, false)),
  SECOND_PLACE(2, 30000000, 5, Set.of(true)),
  THIRD_PLACE(3, 1500000, 5, Set.of(false)),
  FOURTH_PLACE(4, 50000, 4, Set.of(true, false)),
  FIFTH_PLACE(5, 5000, 3, Set.of(true, false)),
  LOSE(-1, 0, 0, Set.of(true, false));
  private final int grade;
  private final int price;

  private final int matchCount;
  private final Set<Boolean> matchBonus;

  LottoResult(final int grade, final int price, final int matchCount,
    final Set<Boolean> matchBonus) {
    this.grade = grade;
    this.price = price;
    this.matchCount = matchCount;
    this.matchBonus = matchBonus;
  }

  public int price() {
    return price;
  }

  public int matchCount() {
    return matchCount;
  }

  public static LottoResult lottoResult(final int matchCount, final boolean matchBonus) {
    return Arrays.stream(values())
      .filter(grade -> grade.matchCount == matchCount && grade.matchBonus.contains(matchBonus))
      .findFirst()
      .orElse(LOSE);
  }

  @Override
  public String toString() {
    return "LottoResult{" +
      "grade=" + grade +
      ", price=" + price +
      '}';
  }
}
