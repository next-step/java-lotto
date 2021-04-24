package study.step2.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  public static List<Integer> inputLastLottoNumbers() {
    SCANNER.nextLine();
    System.out.println(MessageUtil.LAST_LOTTO_NUMBER_MESSAGE);
    String inputText = SCANNER.nextLine();

    Validator.isEmpty(inputText);

    String[] splitNumbers = inputText.split(", ");

    List<Integer> numbers = Arrays.stream(splitNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    Validator.validatorNumbers(numbers);

    Collections.sort(numbers);

    return numbers;
  }

}
