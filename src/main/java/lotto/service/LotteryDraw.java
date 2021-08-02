package lotto.service;

import lotto.domain.Lotties;

public class LotteryDraw {

  private int money;

  private Lotties lotties;

  public static final int EACH_LOTTO_COST = 1000;

  public LotteryDraw(int money) {
    this.money = money;
  }

  public void checkInputValue() {
    if (Operation.chooseOperation("%").calculation(money,EACH_LOTTO_COST) != 0) {
      throw new RuntimeException("금액을 정상적으로 입력해주세요.");
    }
  }

  public int getNumberOfLotto() {
    return Operation.chooseOperation("/").calculation(money,EACH_LOTTO_COST);
  }

  public void buyLotties() {
    checkInputValue();
    lotties = new Lotties(getNumberOfLotto());
  }

  public Lotties getLottiesInfo() {
    return lotties;
  }
}
