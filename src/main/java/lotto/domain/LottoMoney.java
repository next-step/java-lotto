package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.service.Operation;
import lotto.message.Message;

public class LottoMoney {

  private final int money;

  public static final int LIMIT_MIN_NUMBER = 0;

  private static final String PROFIT_RATE_FORMAT = "#.##";

  public LottoMoney(int money) {

    if(money < LIMIT_MIN_NUMBER){
      throw new IllegalArgumentException(Message.MSG_ERROR_LIMIT_MONEY);
    }
    this.money = money;
  }

  public int calculateMoney(String mark, final int eachLottoCost) {
    return Operation.chooseOperation(mark).calculation(money,eachLottoCost);
  }

  public String getReward(final double totalWinningRewards) {
    return formattingValue(totalWinningRewards / (double) money);
  }

  private String formattingValue(double reward) {

    DecimalFormat format = new DecimalFormat(PROFIT_RATE_FORMAT);
    format.setRoundingMode(RoundingMode.DOWN);

    return format.format(reward);
  }
}
