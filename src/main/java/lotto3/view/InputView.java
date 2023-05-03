package lotto3.view;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto3.domain.BonusNumber;
import lotto3.domain.Money;
import lotto3.domain.WinningNumbers;

public class InputView {

  private static final String DELIMITER = ",\\s*";
  private static final Scanner SCANNER = new Scanner(System.in);

  public static Money scanMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    String investMoney = SCANNER.nextLine();
    validateMoney(investMoney);
    return new Money(Integer.parseInt(investMoney));
  }

  private static void validateMoney(String investMoney) {
    if (isBlank(investMoney)) {
      throw new IllegalArgumentException("구입금액을 입력해 주세요.");
    }
    if (!isNumber(investMoney)) {
      throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
    }
  }


  private static boolean isNumber(String investMoney) {
    return investMoney.matches("^[0-9]*$");
  }

  public static WinningNumbers scanWinningNumbers() {
    System.out.println();
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String winningNumbers = SCANNER.nextLine();
    validateBlank(winningNumbers);
    return convertWinningNumbers(winningNumbers);
  }

  private static void validateBlank(String winningNumbers) {
    if (isBlank(winningNumbers)) {
      throw new IllegalArgumentException("지난 주 당첨 번호를 입력해 주세요.");
    }
  }


  private static boolean isBlank(String winningNumbers) {
    return winningNumbers == null || winningNumbers.isBlank();
  }

  private static WinningNumbers convertWinningNumbers(String winningNumbers) {
    String[] splitNumbers = splitWithDelimiter(winningNumbers);
    List<Integer> numbers = Arrays.stream(splitNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return new WinningNumbers(numbers);
  }

  private static String[] splitWithDelimiter(String winningNumbers) {
    return winningNumbers.split(DELIMITER);
  }

  public static BonusNumber scanBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    String bonusNumber = SCANNER.nextLine();
    validateBlank(bonusNumber);
    validateIsNumber(bonusNumber);
    return new BonusNumber(Integer.parseInt(bonusNumber));
  }

  private static void validateIsNumber(String bonusNumber) {
    if (!isNumber(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 숫자만 입력 가능합니다.");
    }
  }


}
