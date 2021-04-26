package study.step2.validator;

import static study.step2.utils.MessageUtil.LOTTO_NUMBER_DUPLICATED;
import static study.step2.utils.MessageUtil.VALIDATOR_MONEY_MESSAGE;
import static study.step2.utils.MessageUtil.VALIDATOR_NUMBER_MESSAGE;

import java.util.Set;

public class Validator {

  private static final int VALIDATOR_MONEY = 1000;
  private static final int NUMBER_OF_LOTTO_NUMBER = 6;

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

  public static void validatorPositiveNumbers(Set<Integer> numbers) {
    boolean result = numbers.stream().anyMatch(number -> number < 0);

    if (result) {
      throw new IllegalArgumentException(VALIDATOR_NUMBER_MESSAGE);
    }
  }

  public static void checkDuplication(Set<Integer> numbers) {
    if (numbers.size() != NUMBER_OF_LOTTO_NUMBER) {
      throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED);
    }
  }

}
