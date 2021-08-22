package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int getInputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    int money = Integer.parseInt(scanner.nextLine());
    return money;
  }

  public static Lotto getWinningLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = scanner.nextLine();
    List<Integer> numbers = Arrays.stream(input.split(",")).map(String::trim).map(Integer::valueOf).collect(
        Collectors.toList());
    return new Lotto(numbers);
  }
}
