package lotto.enums;

import java.util.Arrays;

public enum Grade {
  NONE(0, 0),
  FIFTH(3, 5_000),
  FOURTH(4, 50_000),
  THIRD(5, 1_500_000),
  SECOND(5, 30_000_000),
  FIRST(6, 2_000_000_000);

  private final int expectNumber;
  private final int awardPrice;

  Grade(int expectNumber, int awardPrice) {
    this.expectNumber = expectNumber;
    this.awardPrice = awardPrice;
  }

  public int getExpectNumber() {
    return expectNumber;
  }

  public long getAwardPrice() {
    return awardPrice;
  }

  public static Grade valueOf(int countOfMatch, boolean matchBonus) {
    Grade second = Grade.SECOND;
    if (matchBonus && second.expectNumber == countOfMatch) {
      return second;
    }

    return Arrays.stream(values())
        .filter(grade -> grade != second)
        .filter(grade -> grade.expectNumber == countOfMatch)
        .findFirst()
        .orElse(Grade.NONE);
  }

}
