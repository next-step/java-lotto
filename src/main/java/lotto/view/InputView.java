package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InputView {

  public static int inputPrice(Scanner scanner) {
    System.out.println("구입금액을 입력해주세요.");
    try {
      return Integer.valueOf(scanner.nextLine());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }
  }

  public static List<Integer> winNumbers(Scanner scanner) {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    return Stream.of(scanner.nextLine().split(","))
        .map(String::trim)
        .mapToInt(Integer::valueOf)
        .boxed()
        .collect(toList());
  }
}