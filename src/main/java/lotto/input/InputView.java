package lotto.input;

import java.util.Scanner;

public final class InputView {

  public PurchaseAmountQuantity getPurchaseAmountQuantity() {
    System.out.println("구매 금액을 입력해주세요.");

    return new PurchaseAmountQuantity(new Scanner(System.in).nextInt());
  }

  public WinningNumber getWinningNumber() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String[] splitNumbers = getInputSplitNumbers();

    return new WinningNumber(getParsedNumbersFrom(splitNumbers));
  }

  private String[] getInputSplitNumbers() {
    return new Scanner(System.in)
        .nextLine()
        .split(",");
  }

  private int[] getParsedNumbersFrom(String[] splitNumbers) {
    int[] numbers = new int[6];
    for (int i = 0; i < splitNumbers.length; i++) {
      numbers[i] = Integer.parseInt(splitNumbers[i]);
    }

    return numbers;
  }
}
