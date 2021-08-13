package lotto.view;

import java.util.List;
import java.util.Scanner;
import lotto.domain.PurchaseCount;

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

  public static List<String> inputStringValuesWithMessage(String message,
      final PurchaseCount purchaseCount) {

    System.out.println(message);

    Scanner scanner = new Scanner(System.in);
    return purchaseCount.createManualNumbers(scanner);
  }
}
