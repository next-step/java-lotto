package util;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);


  private InputView() {}

  public static Integer scanInt(String description) {
    printDescription(description);
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static String scanString(String description) {
    printDescription(description);
    return SCANNER.nextLine();
  }

  private static void printDescription(String description) {
    System.out.println(description);
  }

}
