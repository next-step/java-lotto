package lotto.domain;

public final class LottoBall {
  private static final int MIN = 1;
  private static final int MAX = 45;

  private static LottoBall lottoBall;
  private int number;

  private LottoBall(int number) {
    if (number < MIN || number > MAX) {
      throw new IllegalArgumentException("로또공 생성가능한 숫자가 아닙니다.");
    }
    this.number = number;
  }

  public static LottoBall create(int number) {
    if (lottoBall == null) {
      lottoBall = new LottoBall(number);
    }
    return lottoBall;
  }

}
