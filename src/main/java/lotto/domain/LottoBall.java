package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class LottoBall implements Comparable<LottoBall> {

  private static final int MIN = 1;
  private static final int MAX = 45;
  private static final List<LottoBall> CACHE_LOTTOBALL = new ArrayList<>();
  private final int number;

  static {
    for (int i = MIN; i <= MAX; i++) {
      CACHE_LOTTOBALL.add(new LottoBall(i));
    }
  }

  public static List<LottoBall> draw() {
    Collections.shuffle(CACHE_LOTTOBALL);
    List<LottoBall> ballsDraw = new ArrayList<>(CACHE_LOTTOBALL.subList(0, 6));
    Collections.sort(ballsDraw);
    return ballsDraw;
  }

  public LottoBall(final int number) {
    if (number < MIN || number > MAX) {
      throw new IllegalArgumentException("로또공 생성가능한 숫자가 아닙니다.");
    }
    this.number = number;
  }

  @Override
  public String toString() {
    return String.valueOf(this.number);
  }

  @Override
  public int compareTo(LottoBall other) {
    return Integer.compare(this.number, other.number);
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
