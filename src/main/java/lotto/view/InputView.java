package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.Money;
import lotto.Number;

public class InputView {

  private Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public Money inputPurchaseAmount() {

    System.out.println("구입금액을 입력해 주세요.");
    return new Money(this.scanner.nextInt());
  }

  public List<Number> inputWinNumbers() {

    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String[] inputNumbers = this.scanner.next().split(", ");

    return Arrays.stream(inputNumbers)
        .map(Number::new)
        .collect(Collectors.toList());
  }
}
