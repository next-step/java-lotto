package lotto.input;

import java.util.Scanner;

public final class InputView {

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public PurchaseAmountQuantity getPurchaseAmountQuantity() {
    System.out.println("구매 금액을 입력해주세요.");

    return new PurchaseAmountQuantity(new Scanner(System.in).nextInt());
  }

  public WinningNumber getWinningNumber() {
    return new WinningNumber(
        getParsedNumbersFrom(getWinningNumbers()),
        getBonusNumber()
    );
  }

  private String[] getWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    return scanner.nextLine().split(",");
  }

  private int getBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");

    return scanner.nextInt();
  }


  private int[] getParsedNumbersFrom(String[] splitNumbers) {
    int[] numbers = new int[6];
    for (int i = 0; i < splitNumbers.length; i++) {
      numbers[i] = Integer.parseInt(splitNumbers[i]);
    }

    return numbers;
  }
}
