package study.step2.view;

import java.util.Scanner;
import study.step2.utils.MessageUtil;
import study.step2.validator.Validator;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {}

  public static int inputMoney() {
    System.out.println(MessageUtil.INPUT_MONEY_MESSAGE);

    int money = SCANNER.nextInt();

    Validator.validatorMoney(money);

    return money;
  }

  public static String inputLastLottoNumbers() {
    SCANNER.nextLine();

    System.out.println(MessageUtil.LAST_LOTTO_NUMBER_MESSAGE);

    String inputText = SCANNER.nextLine();

    Validator.isEmpty(inputText);

    return inputText;
  }

  public static int inputBonusNumber() {
    System.out.println(MessageUtil.INPUT_BONUS_NUMBER_MESSAGE);

    return SCANNER.nextInt();
  }

}
