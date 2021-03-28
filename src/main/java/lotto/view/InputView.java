package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Money;

public class InputView {
  private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
  private static final String INPUT_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
  private final Scanner scanner = new Scanner(System.in);

  public Money inputMoney() {
    System.out.println(INPUT_MONEY);
    int money = scanner.nextInt();
    return new Money(money);
  }

  public List<Integer> inputWinNumbers() {
    System.out.println(INPUT_WIN_NUMBERS);
    String winNumberString = scanner.next();
    List<Integer> result  = Arrays.stream(winNumberString.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return result;
  }
}
