package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  public static final String READ_PRICE_QUESTION = "구입금액을 입력해 주세요.";
  public static final String READ_PREVIOUS_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String DELIMITER = ",";
  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public int readPrice() {
    System.out.println(READ_PRICE_QUESTION);
    int price = scanner.nextInt();
    scanner.nextLine();
    return price;
  }

  public List<Integer> readPreviousNumbers() {
    System.out.println(READ_PREVIOUS_NUMBER_QUESTION);
    return Arrays.stream(scanner.nextLine().split(DELIMITER))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
