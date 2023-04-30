package lotto;

import java.util.Scanner;

public class Reader {
  private final static Scanner SCANNER = new Scanner(System.in);

  private Reader() {}

  public static String read() {
    return SCANNER.nextLine();
  }
}
