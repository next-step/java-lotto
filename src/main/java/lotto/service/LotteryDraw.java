package lotto.service;

import lotto.domain.Lotties;

public class LotteryDraw {

  private int money;

  public static final int EACH_LOTTO_COST = 1000;

  public LotteryDraw(int money) {
    this.money = money;
  }

  public void checkInputValue() {
    if (money % 1000 != 0) {
      throw new RuntimeException("금액을 정상적으로 입력해주세요.");
    }
  }

  public int getNumberOfLotto() {
    return money / EACH_LOTTO_COST;
  }
}
