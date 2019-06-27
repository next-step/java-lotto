package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InputView {

  public static int inputPrice(Scanner scanner) {
    System.out.println("구입금액을 입력해주세요.");
    return Integer.valueOf(
        validateInput(scanner.nextLine()));
  }

  private static String validateInput(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException("잘못된 입력입니다.");
    }
    return input;
  }

  public static List<Integer> winNumbers(Scanner scanner) {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    return Stream.of(scanner.nextLine().split(","))
        .map(String::trim)
        .mapToInt(Integer::valueOf)
        .boxed()
        .collect(toList());
  }

  public static int bonusNumber(Scanner scanner) {
    System.out.println("보너스 볼을 입력해 주세요.");
    int bonusNumber = Integer.valueOf(scanner.nextLine());
    return bonusNumber;
  }
}