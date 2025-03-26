package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  public static int getPurchaseAmount(Scanner scanner) {
    System.out.println("구입 금액을 입력해 주세요.");
    int purchaseAmount = scanner.nextInt();
    return purchaseAmount;
  }

  public static List<Integer> getWinningNumbers(Scanner scanner) {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    scanner.nextLine();
    return Arrays.stream(scanner.nextLine().split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
