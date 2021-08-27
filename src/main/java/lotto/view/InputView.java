package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static Money inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Money(Integer.parseInt(scanner.nextLine()));
  }

  public static Lotto winningLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = scanner.nextLine();
    List<Integer> numbers = Arrays.stream(input.split(","))
        .map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
    return Lotto.issueByManual(numbers);
  }
}
