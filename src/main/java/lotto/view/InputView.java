package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
      final int manualCount) {

    System.out.println(message);

    Scanner scanner = new Scanner(System.in);
    return IntStream.range(0, manualCount)
        .mapToObj(number -> scanner.nextLine())
        .collect(Collectors.toList());
  }
}
