package lotto.view;

import java.util.Scanner;

public class InputView {

  public static int inputValueWithMessage(String message) {
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static String inputStringValueWithMessage(String message) {
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
