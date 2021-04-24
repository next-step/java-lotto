package study.step2.validator;

import java.util.List;
import study.step2.utils.MessageUtil;

public class Validator {

  private static final int VALIDATOR_MONEY = 1000;

  private Validator() {}

  public static void validatorMoney(int money) {
    if (money < VALIDATOR_MONEY) {
      throw new IllegalArgumentException(MessageUtil.VALIDATOR_MONEY_MESSAGE);
    }
  }

  public static void isEmpty(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException(MessageUtil.VALIDATOR_NUMBER_MESSAGE);
    }
  }

  public static void validatorNumbers(List<Integer> numbers) {
    boolean result = numbers.stream().anyMatch(number -> number < 0);

    if (result) {
      throw new RuntimeException();
    }
  }
}
