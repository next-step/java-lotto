package lotto.domain;

import lotto.Message.Message;

public class LottoMoney {

  private final int money;

  public static final int LIMIT_NUMBER = 0;

  public LottoMoney(int money) {
    if(money < LIMIT_NUMBER){
      throw new IllegalArgumentException(Message.MSG_ERROR_LIMIT_MONEY);
    }
    this.money = money;
  }

  public int getMoney() {
    return money;
  }
}
