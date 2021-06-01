package lotto.input;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class InputView {

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public PurchaseAmountQuantity input() {
    int amount = getAmount();
    int manualCount = getManualCount();
    List<String> manualLottoNumbers = getManualLottoNumbers(manualCount);

    return new PurchaseAmountQuantity(amount, manualCount, manualLottoNumbers);
  }

  private int getAmount() {
    System.out.println("구매 금액을 입력해주세요.");

    int amount = scanner.nextInt();
    clearScanner();

    return amount;
  }

  private int getManualCount() {
    System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");

    int manualCount = scanner.nextInt();
    clearScanner();

    return manualCount;
  }

  private List<String> getManualLottoNumbers(int manualCount) {
    System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

    return IntStream
        .range(0, manualCount)
        .mapToObj(i -> scanner.nextLine())
        .collect(Collectors.toList());
  }

  public WinningNumber getWinningNumber() {
    return new WinningNumber(
        getParsedNumbersFrom(getWinningNumbers()),
        getBonusNumber()
    );
  }

  private String[] getWinningNumbers() {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

    return getStringValueFromUser().split(",");
  }

  private int getBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");

    return getIntValueFromUser();
  }

  private int[] getParsedNumbersFrom(String[] splitNumbers) {
    int[] numbers = new int[6];
    for (int i = 0; i < splitNumbers.length; i++) {
      numbers[i] = Integer.parseInt(splitNumbers[i]);
    }

    return numbers;
  }

  private int getIntValueFromUser() {
    int amount = scanner.nextInt();
    clearScanner();

    return amount;
  }

  private String getStringValueFromUser() {
    return scanner.nextLine();
  }

  private void clearScanner() {
    scanner.nextLine();
  }
}
