package view;

import domain.LottoTicket;
import java.util.List;
import java.util.Scanner;
import util.Converter;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int scanMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    int investMoney = scanner.nextInt();
    validateInvestMoney(investMoney);
    return investMoney;
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
    String winningNumbers = scanner.next();
    return Converter.convertToLottoNumbers(winningNumbers);
  }

}
