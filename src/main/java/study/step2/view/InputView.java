package study.step2.view;

import java.util.ArrayList;
import java.util.List;
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
    System.out.println(MessageUtil.LAST_LOTTO_NUMBER_MESSAGE);

    String inputText = SCANNER.nextLine();

    Validator.isEmpty(inputText);

    return inputText;
  }

  public static int inputBonusNumber() {
    System.out.println(MessageUtil.INPUT_BONUS_NUMBER_MESSAGE);

    return SCANNER.nextInt();
  }

  public static int manualInputLottoCount(int money) {
    SCANNER.nextLine();

    System.out.println(MessageUtil.MANUAL_LOTTO_COUNT_MESSAGE);

    int manualInputLottoCount = SCANNER.nextInt();

    Validator.validatorManualInputLottoCount(manualInputLottoCount, money);

    return manualInputLottoCount;
  }

  public static List<String> manualInputLottos(int manualInputLottoCount) {
    SCANNER.nextLine();

    System.out.println(MessageUtil.MANUAL_LOTTO_NUMBER_INPUT_MESSAGE);

    List<String> inputLottos = new ArrayList<>();

    for (int i = 0; i < manualInputLottoCount; i++) {
      String inputText = SCANNER.nextLine();
      Validator.isEmpty(inputText);
      inputLottos.add(inputText);
    }

    return inputLottos;
  }

}
