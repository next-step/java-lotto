package lotto.view;

import java.util.Scanner;
import lotto.domain.Money;

public class InputView {
  private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
  private final Scanner scanner = new Scanner(System.in);

  public Money inputMoney() {
    System.out.println(INPUT_MONEY);
    int money = scanner.nextInt();
    return new Money(money);
  }

}
