package lotto.view;

import java.util.Scanner;

public class InputView {

  public static final String READ_PRICE_QUESTION = "구입금액을 입력해 주세요.";
  public static final String READ_PREVIOUS_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public int readPrice() {
    System.out.println(READ_PRICE_QUESTION);
    return scanner.nextInt();
  }

  public String[] readPreviousNumbers() {
    System.out.println(READ_PREVIOUS_NUMBER_QUESTION);
    String input = scanner.nextLine();
    return input.split(", ");
  }
}
