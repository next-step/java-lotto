package lotto.view;

import java.util.Scanner;

public final class InputTable {

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputTable() {
  }

  public static Integer inputHaveMoney() {
    return SCANNER.nextInt();
  }

  public static String inputAwardNumber() {
    return SCANNER.next();
  }
}
