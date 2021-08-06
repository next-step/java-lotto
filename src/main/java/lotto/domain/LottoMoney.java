package lotto.domain;

import lotto.message.Message;
import lotto.service.Operation;

public class LottoMoney {

  private static final int LIMIT_MIN_NUMBER = 0;

  private static final int EACH_LOTTO_COST = 1000;

  private static final int INT_ZERO = 0;

  private final int money;

  public LottoMoney(int money) {
    this.money = checkEnoughValue(checkMinimumValue(money));
  }

  private int checkMinimumValue(final int money) {
    if(isLessThanLimit(money)){
      throw new IllegalArgumentException(Message.MSG_ERROR_LIMIT_MONEY);
    }
    return money;
  }

  private boolean isLessThanLimit(final int money) {
    return money < LIMIT_MIN_NUMBER;
  }

  private int checkEnoughValue(int money) {
    if (isNotEnough(money)) {
      throw new RuntimeException(Message.MSG_ERROR_WRONG_MONEY);
    }
    return money;
  }

  private boolean isNotEnough(int money) {
    return calculateMoney(Operation.DIVISION_REMAINDER, EACH_LOTTO_COST, money) != INT_ZERO;
  }

  public int calculateMoney(Operation mark, final int eachLottoCost, int money) {
    return Operation.chooseOperation(mark.getOperation()).calculation(money,eachLottoCost);
  }

  public double getReward(final double totalWinningRewards) {
    return totalWinningRewards / (double) money;
  }

  public int countLottoToMoney(final Operation mark, final int eachLottoCost) {
    return calculateMoney(mark,eachLottoCost,money);
  }
}
