package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int readPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return parseIntOrThrow(SCANNER.nextLine());
  }

  public static List<Integer> readWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = SCANNER.nextLine();
    String[] numberStrings = input.split(",");
    List<Integer> winningNumbers = new ArrayList<>();
    for (String s : numberStrings) {
      winningNumbers.add(parseIntOrThrow(s));
    }
    return winningNumbers;
  }

  private static int parseIntOrThrow(String input) {
    try {
      return Integer.parseInt(input.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자만 입력 가능합니다: " + input);
    }
  }

}
