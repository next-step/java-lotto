package step2;

import java.util.Scanner;

public class LottoSalesman {
  private static String SCRIP_AMOUNT = "구입금액을 입력해 주세요.";
  private static String SCRIP_MANUAL_LOTTO_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String SCRIP_INPUT_LOTTO_NUMBERS = "\n수동으로 구매할 번호를 입력해 주세요.";
  private static final String SCRIPT_WINNING_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
  private static final String SCRIPT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
  private final Scanner scanner;

  public LottoSalesman(Scanner scanner) {
    this.scanner = scanner;
  }

  public int purchaseAmount(int onePrice) {
    return purchaseAmount(true, onePrice);
  }

  private int purchaseAmount(boolean first, int onePrice) {
    System.out.println(printScriptAmount(first, onePrice));

    int payment = scanner.nextInt();
    if (isPossibleBuy(onePrice, payment)) {
      return payment;
    }

    return purchaseAmount(false, onePrice);
  }

  private String printScriptAmount(boolean first, int onePrice) {
    if (first) return SCRIP_AMOUNT;

    return String.format("%s(%d원 이상)", SCRIP_AMOUNT, onePrice);
  }

  private boolean isPossibleBuy(int onePrice, int payment) {
    return payment >= onePrice;
  }

  public int manualLottoCount(int onePrice, int payment) {
    return manualLottoCount(true, onePrice, payment);
  }

  private int manualLottoCount(boolean first, int onePrice, int payment) {
    int canBuyCount = payment / onePrice ;
    System.out.println(printScriptManualLottoCount(first, canBuyCount));

    int count = scanner.nextInt();
    if (isPossibleCount(canBuyCount, count)) {
      return count;
    }

    return manualLottoCount(false, onePrice, payment);
  }

  private String printScriptManualLottoCount(boolean first, int canBuyCount) {
    if (first) return SCRIP_MANUAL_LOTTO_COUNT;

    return String.format("%s(%d까지 구입가능)", SCRIP_MANUAL_LOTTO_COUNT, canBuyCount);
  }

  private boolean isPossibleCount(int canBuyCount, int count) {
    return canBuyCount >= count;
  }

  public String[] inputManualLotto(int lottoCount) {
    System.out.println(SCRIP_INPUT_LOTTO_NUMBERS);
    String lottoNumbers[] = new String[lottoCount];
    for (int i = 0; i < lottoCount; i++) {
      lottoNumbers[i] = scanner.next();
    }

    return lottoNumbers;
  }

  public void informPurchase(Lottos manualLottos, Lottos autoLottos) {
    System.out.println(
        String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottos.count(), autoLottos.count()));
    for (Lotto lotto : manualLottos) {
      System.out.println(lotto);
    }

    for (Lotto lotto : autoLottos) {
      System.out.println(lotto);
    }
  }


  public String winningNumber() {
    System.out.println(SCRIPT_WINNING_NUMBER);
    return scanner.next();
  }

  public int bonusNumber() {
    System.out.println(SCRIPT_BONUS_NUMBER);
    return scanner.nextInt();
  }

}
