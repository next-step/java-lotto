package nextstep.lotto.domain;

import java.util.Arrays;

public enum LottoResult {
  FIRST_PLACE(1, 2000000000, 6),
  SECOND_PLACE(2, 1500000, 5),
  THIRD_PLACE(3, 50000, 4),
  FOURTH_PLACE(4, 5000, 3),
  LOSE(-1, 0, 0);
  private final int grade;
  private final int price;

  private final int matchCount;

  LottoResult(final int grade, final int price, final int matchCount) {
    this.grade = grade;
    this.price = price;
    this.matchCount = matchCount;
  }

  public int price() {
    return price;
  }
  public int matchCount() {
    return matchCount;
  }

  public static LottoResult lottoResult(final int matchCount) {
    return Arrays.stream(values())
      .filter(grade -> grade.matchCount == matchCount)
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
