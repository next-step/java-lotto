package nextstep.lotto.domain;

import java.util.Arrays;

public enum LottoResult {
  FIRST_PLACE(1, 2000000000, 6, false),
  SECOND_PLACE(2, 30000000, 5, true),
  THIRD_PLACE(3, 1500000, 5, false),
  FOURTH_PLACE(4, 50000, 4, false),
  FIFTH_PLACE(5, 5000, 3, false),
  LOSE(-1, 0, 0, false);
  private final int grade;
  private final int price;

  private final int matchCount;
  private final boolean matchBonus;

  LottoResult(final int grade, final int price, final int matchCount, final boolean matchBonus) {
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

  public boolean matchBonus() {
    return matchBonus;
  }

  public static LottoResult lottoResult(final int matchCount, final boolean bonus) {
    return Arrays.stream(values())
      .filter(grade -> grade.matchCount == matchCount && grade.checkBonus(bonus))
      .findFirst()
      .orElse(LOSE);
  }

  private boolean checkBonus(final boolean bonus) {
    if(this.matchBonus) {
      return bonus;
    }
    return true;
  }

  @Override
  public String toString() {
    return "LottoResult{" +
      "grade=" + grade +
      ", price=" + price +
      '}';
  }
}
