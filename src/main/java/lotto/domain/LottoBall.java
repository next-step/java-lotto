package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LottoBall implements Comparable<LottoBall> {
  private static final int MIN = 1;
  private static final int MAX = 45;
  private static final List<LottoBall> CACHE_LOTTOBALL = new ArrayList<>();

  static {
    for (int i = MIN ; i <= MAX ; i++ ) {
      CACHE_LOTTOBALL.add(new LottoBall(i));
    }
  }

  public static List<LottoBall> values() {
    return CACHE_LOTTOBALL;
  }

  private final int number;

  public LottoBall(final int number) {
    if (number < MIN || number > MAX) {
      throw new IllegalArgumentException("로또공 생성가능한 숫자가 아닙니다.");
    }
    this.number = number;
  }

  public int getNumber() {
    return this.number;
  }

  @Override
  public int compareTo(LottoBall other) {
    return this.number > other.getNumber() ? 1 : -1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoBall lottoBall = (LottoBall) o;
    return number == lottoBall.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
