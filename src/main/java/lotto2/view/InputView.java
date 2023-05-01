package lotto2.view;

import static lotto2.domain.LottoTicket.TICKET_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int scanMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    String investMoney = SCANNER.nextLine();
    validateMoney(investMoney);
    return Integer.parseInt(investMoney);
  }

  private static void validateMoney(String investMoney) {
    if (isBlank(investMoney)) {
      throw new IllegalArgumentException("구입금액을 입력해 주세요.");
    }
    if (!isNumber(investMoney)) {
      throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
    }
    if (!isThousands(investMoney)) {
      throw new IllegalArgumentException("구입금액은 1000원 단위로 입력 가능합니다.");
    }
  }

  private static boolean isThousands(String investMoney) {
    return Integer.parseInt(investMoney) % TICKET_PRICE == 0;
  }

  private static boolean isNumber(String investMoney) {
    return investMoney.matches("^[0-9]*$");
  }

  public static List<Integer> scanWinningNumbers() {
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
    List<Integer> lottoNumbers = convertToLottoNumbers(winningNumbers);
    return lottoNumbers.stream()
        .allMatch(number -> number >= 1 && number <= 45);
  }

  private static boolean hasSixNumbers(String winningNumbers) {
    return winningNumbers.split(",\\s*").length == 6;
  }

  private static boolean isBlank(String winningNumbers) {
    return winningNumbers == null || winningNumbers.isBlank();
  }

  private static List<Integer> convertToLottoNumbers(String winningNumbers) {
    String[] numbers = winningNumbers.split(",\\s*");
    return Arrays.stream(numbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
