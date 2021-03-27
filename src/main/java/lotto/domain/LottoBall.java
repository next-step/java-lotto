package lotto.domain;

public final class LottoBall implements Comparable<LottoBall> {
  private static final int MIN = 1;
  private static final int MAX = 45;

  private final int number;

  public LottoBall(int number) {
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
}
