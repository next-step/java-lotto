package step2.domain.number;

import step2.exception.InvalidLottoNumberException;

public class Number {
  final int number;

  private static final String UNDER_LOTTO_MIN_LIMIT = "로또의 최소 번호는 1입니다.";
  private static final String OVER_LOTTO_MAX_LIMIT = "로또의 최대 번호는 45입니다.";
  private static final int LOTTO_MIN = 0;
  private static final int LOTTO_MAX = 45;

  public Number() {
    this(0);
  }

  public Number(int number) {
    if (number < LOTTO_MIN) {
      throw new InvalidLottoNumberException(UNDER_LOTTO_MIN_LIMIT + number);
    }

    if (number > LOTTO_MAX) {
      throw new InvalidLottoNumberException(OVER_LOTTO_MAX_LIMIT + number);
    }
    this.number = number;
  }

  int compareTo(Number targetNumber) {
    return 0;
  }

  public int showCount() {
    return number;
  }

  public String toString() {
    return String.valueOf(number);
  }
}
