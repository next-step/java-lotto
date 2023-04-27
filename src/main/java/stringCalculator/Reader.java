package stringCalculator;

import java.util.Scanner;

public class Reader {
  private final static Scanner SCANNER = new Scanner(System.in);

  public static String read() {
    String input = SCANNER.nextLine();

    if (input.isBlank()) {
      throw new IllegalArgumentException("입력값이 없습니다");
    }

    return input;
  }
}
