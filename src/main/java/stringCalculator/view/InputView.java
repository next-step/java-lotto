package stringCalculator.view;

import java.util.Scanner;

public class InputView {

  public static String getInputScannerWithMessage(String message) {
    System.out.println(message);
    Scanner sc = new Scanner(System.in);
    return sc.nextLine().replace("\\n","\n");
  }
}
