package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int inputPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public static String inputWinningLottoNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public static int inputBonusNumber() {
    System.out.println("보너스 번호를 입력해주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public static int inputManualLottoCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public static List<String> inputManualLottoTickets(int manualLottoCount) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<String> tickets = new ArrayList<>();
    for(int i = 0; i < manualLottoCount; i++){
      tickets.add(scanner.nextLine());
    }
    return tickets;
  }
}
