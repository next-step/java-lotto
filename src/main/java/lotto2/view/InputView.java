package lotto2.view;

import lotto2.domain.LottoTicket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int scanMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    String investMoney = SCANNER.nextLine();
    validateInvestMoney(Integer.parseInt(investMoney));
    return Integer.parseInt(investMoney);
  }

  private static void validateInvestMoney(int investMoney) {
    if (isUnderTicketPrice(investMoney)) {
      throw new IllegalArgumentException("로또 구입 금액은 1000원 이상이어야 합니다.");
    }
    if (isNotThousands(investMoney)) {
      throw new IllegalArgumentException("로또 구입 금액은 1000원 단위여야 합니다.");
    }
  }

  private static boolean isNotThousands(int investMoney) {
    return investMoney % LottoTicket.PRICE != 0;
  }

  private static boolean isUnderTicketPrice(int investMoney) {
    return investMoney < LottoTicket.PRICE;
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
      throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
    }
    if (!hasSixNumbers(winningNumbers)) {
      throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
    }
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
