package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.message.Message;
import lotto.service.Operation;

public class LottoMoney {

  private static final int LIMIT_MIN_NUMBER = 0;

  private final int money;

  public LottoMoney(int money) {

    if(money < LIMIT_MIN_NUMBER){
      throw new IllegalArgumentException(Message.MSG_ERROR_LIMIT_MONEY);
    }
    this.money = money;
  }

  public int calculateMoney(Operation mark, final int eachLottoCost) {
    return Operation.chooseOperation(mark.getOperation()).calculation(money,eachLottoCost);
  }

  public double getReward(final double totalWinningRewards) {
    return totalWinningRewards / (double) money;
  }

}
