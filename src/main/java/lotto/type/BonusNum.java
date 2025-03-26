package lotto.type;

public class BonusNum {
  int num;

  public static BonusNum valueOf(int num, int lottoMaxNum) {
    return new BonusNum(num, lottoMaxNum);
  }

  private BonusNum(int num, int  lottoMaxNum) {
    if (num > lottoMaxNum || num < 1) {
      throw new IllegalArgumentException(String.format("not valid bonus number: %d", num));
    }
    this.num = num;
  }

  public boolean isMatch(int num) {
    return this.num == num;
  }
}
