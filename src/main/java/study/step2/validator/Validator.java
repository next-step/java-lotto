package study.step2.validator;

import static study.step2.utils.MessageUtil.VALIDATOR_MONEY_MESSAGE;
import static study.step2.utils.MessageUtil.VALIDATOR_NUMBER_MESSAGE;


public class Validator {

  private static final int VALIDATOR_MONEY = 1000;
  public static final int NUMBER_OF_LOTTO_NUMBER = 6;

  private Validator() {}

  public static void validatorMoney(int money) {
    if (money < VALIDATOR_MONEY) {
      throw new IllegalArgumentException(VALIDATOR_MONEY_MESSAGE);
    }
  }

  public static void isEmpty(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException(VALIDATOR_NUMBER_MESSAGE);
    }
  }

}
