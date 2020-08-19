package step2;

import java.util.Scanner;

public class LottoSalesman {

  private static final String SCRIP_AMOUNT = "구입금액을 입력해 주세요.";
  private static final String SCRIP_MANUAL_LOTTO_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String SCRIP_INPUT_LOTTO_NUMBERS = "\n수동으로 구매할 번호를 입력해 주세요.";
  private static final String SCRIPT_WINNING_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
  private static final String SCRIPT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
  private static final String SCRIPT_INFORM_WINNING = "\n당첨 통계";

  public static int purchaseAmount(Scanner scanner) {
    System.out.println(SCRIP_AMOUNT);

    return scanner.nextInt();
  }

  public static int manualLottoCount(Scanner scanner) {
    System.out.println(SCRIP_MANUAL_LOTTO_COUNT);
    return scanner.nextInt();
  }

  public static String[] inputManualLotto(Scanner scanner, int lottoCount) {
    System.out.println(SCRIP_INPUT_LOTTO_NUMBERS);
    String lottoNumbers[] = new String[lottoCount];
    for (int i = 0; i < lottoCount; i++) {
      lottoNumbers[i] = scanner.next();
    }
    return lottoNumbers;
  }

  public static void informPurchase(Lottos manualLottos, Lottos autoLottos) {
    System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",manualLottos.count(), autoLottos.count()));
    for (Lotto lotto : manualLottos) {
      System.out.println(lotto.numbers);
    }

    for (Lotto lotto : autoLottos) {
      System.out.println(lotto.numbers);
    }
  }

  public static String winningNumber(Scanner scanner) {
    System.out.println(SCRIPT_WINNING_NUMBER);
    return scanner.next();
  }

  public static int bonusNumber(Scanner scanner) {
    System.out.println(SCRIPT_BONUS_NUMBER);
    return scanner.nextInt();
  }

  public static void informWinning(Scanner scanner, LottoStats analyze, int payment) {
    System.out.println(SCRIPT_INFORM_WINNING);
    System.out.println("--------");
    System.out.print(analyze);
    System.out.printf("총 수익률은 %.2f입니다.", analyze.rate(payment));
  }
}
