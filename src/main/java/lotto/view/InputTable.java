package lotto.view;

import java.util.Scanner;

public final class InputTable {

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputTable() {
  }

  public static Integer inputHaveMoney() {
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static String inputAwardNumber() {
    return SCANNER.nextLine();
  }
}
