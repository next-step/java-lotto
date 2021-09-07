package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.exception.ExceedPurchaseCountException;
import lotto.exception.NegativePurchaseCountException;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static long inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return Long.parseLong(scanner.nextLine());
  }

  public static long inputManualLottoCnt(Money money) {
    System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    long manualLottoCnt = Long.parseLong(scanner.nextLine());

    if (manualLottoCnt > LottoGame.purchaseCnt(money)) {
      throw new ExceedPurchaseCountException();
    }
    if (manualLottoCnt < 0) {
      throw new NegativePurchaseCountException();
    }

    return manualLottoCnt;
  }

  public static List<String> inputManualLottoList(long manualLottoCnt) {
    if (manualLottoCnt <= 0) {
      return Collections.emptyList();
    }
    System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    List<String> manualLottoList = new ArrayList<>();
    for (int i = 0; i < manualLottoCnt; i++) {
      manualLottoList.add(scanner.nextLine());
    }
    return manualLottoList;
  }

  public static String winningLottoNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public static int bonusLottoNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine().trim());
  }
}
