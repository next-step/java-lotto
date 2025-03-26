package lotto.type;

import lotto.LottoSystemConstants;

public class BonusNum {
  int num;

  public static BonusNum valueOf(int num, WinningNums winningNums) {
    return new BonusNum(num, winningNums);
  }

  private BonusNum(int num, WinningNums winningNums) {
    if (num > LottoSystemConstants.LOTTO_MAX_NUM || num < LottoSystemConstants.LOTTO_MIN_NUM) {
      throw new IllegalArgumentException(String.format("not valid bonus number: %d", num));
    }
    if (winningNums.contains(num)) {
      throw new IllegalArgumentException(String.format("winning numbers contains number: %d", num));
    }
    this.num = num;
  }

  public boolean isMatch(int num) {
    return this.num == num;
  }
}
