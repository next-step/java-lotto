package lotto.type;

import lotto.LottoSystemConstants;

public class BonusNum {
  int num;

  public static BonusNum valueOf(int num, WinningNums winningNums) {
    return new BonusNum(num, winningNums);
  }

  private BonusNum(int num, WinningNums winningNums) {
    if (num > LottoSystemConstants.LOTTO_MAX_NUM || num < LottoSystemConstants.LOTTO_MIN_NUM) {
      throw new IllegalArgumentException("유효하지 않은 보너스 숫자입니다.");
    }
    if (winningNums.contains(num)) {
      throw new IllegalArgumentException("유효하지 않은 보너스 숫자입니다.");
    }
    this.num = num;
  }

  public boolean isMatch(int num) {
    return this.num == num;
  }
}
