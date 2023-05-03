package lotto3.view;

import static lotto2.domain.LottoTicket.TICKET_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto3.domain.Money;
import lotto3.domain.WinningNumbers;

public class InputView {

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

  private static boolean isThousands(String investMoney) {
    return Integer.parseInt(investMoney) % TICKET_PRICE == 0;
  }

  private static boolean isNumber(String investMoney) {
    return investMoney.matches("^[0-9]*$");
  }

  public static WinningNumbers scanWinningNumbers() {
    System.out.println();
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String winningNumbers = SCANNER.nextLine();
    validateWinningNumbers(winningNumbers);
    return convertToLottoNumbers(winningNumbers);
  }

  private static void validateWinningNumbers(String winningNumbers) {
    if (isBlank(winningNumbers)) {
      throw new IllegalArgumentException("지난 주 당첨 번호를 입력해 주세요.");
    }

    if (!hasSixNumbers(winningNumbers)) {
      throw new IllegalArgumentException("지난 주 당첨 번호는 6개를 입력해 주세요.");
    }

    if (!isBetweenOneAndFortyFive(winningNumbers)) {
      throw new IllegalArgumentException("지난 주 당첨 번호는 1부터 45까지의 숫자만 가능합니다.");
    }
  }

  private static boolean isBetweenOneAndFortyFive(String winningNumbers) {
    WinningNumbers numbers = convertToLottoNumbers(winningNumbers);
    return numbers.isBetweenOneAndFortyFive();
  }

  private static boolean hasSixNumbers(String winningNumbers) {
    return winningNumbers.split(",\\s*").length == 6;
  }

  private static boolean isBlank(String winningNumbers) {
    return winningNumbers == null || winningNumbers.isBlank();
  }

  private static WinningNumbers convertToLottoNumbers(String winningNumbers) {
    String[] splitNumbers = winningNumbers.split(",\\s*");
    List<Integer> numbers = Arrays.stream(splitNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return new WinningNumbers(numbers);
  }

  public static int scanBonusNumber(WinningNumbers winningNumbers) {
    System.out.println("보너스 볼을 입력해 주세요.");
    String bonusNumber = SCANNER.nextLine();
    validateBonusNumber(bonusNumber, winningNumbers);
    return Integer.parseInt(bonusNumber);
  }

  private static void validateBonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
    if (isBlank(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼을 입력해 주세요.");
    }
    if (!isNumber(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 숫자만 입력 가능합니다.");
    }
    if (!isBetweenOneAndFortyFive(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 1부터 45까지의 숫자만 가능합니다.");
    }
    if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }
  }
}
