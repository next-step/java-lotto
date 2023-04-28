package study.lottogame.ui;

import study.lottogame.domain.Money;

import java.util.Scanner;

public class InputView {
  private static final Scanner sc = new Scanner(System.in);

  public static Money inputPurchaseMoney() {
    System.out.println("구입 금액을 입력해 주세요.");
    String input = sc.nextLine();
    checkNullOrBlank(input);
    return new Money(Integer.parseInt(input));
  }

  private static void checkNullOrBlank(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
  }
}
