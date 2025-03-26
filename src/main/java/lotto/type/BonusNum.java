package lotto.type;

import lotto.LottoSystemConstants;

public class BonusNum {
  int num;

  public static BonusNum valueOf(int num) {
    return new BonusNum(num);
  }

  private BonusNum(int num) {
    if (num > LottoSystemConstants.LOTTO_MAX_NUM || num < LottoSystemConstants.LOTTO_MIN_NUM) {
      throw new IllegalArgumentException(String.format("not valid bonus number: %d", num));
    }
    this.num = num;
  }

  public boolean isMatch(int num) {
    return this.num == num;
  }
}
