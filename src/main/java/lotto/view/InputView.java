package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static int inputCost() {
    System.out.println("구입금액을 입력해 주세요.");
    int cost = scanner.nextInt();
    scanner.nextLine();
    return cost;
  }

  public static Lotto inputWinningLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = scanner.nextLine();
    return Lotto.of(input);
  }

  public static LottoNumber inputBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    String input = scanner.nextLine();
    return LottoNumber.of(input);
  }

  public static int inputManualLottoCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    int manualCount = scanner.nextInt();
    scanner.nextLine();
    return manualCount;
  }

  public static List<Lotto> inputManualLottoNumber(int manualLottoCount) {
    if (manualLottoCount == 0) {
      return new ArrayList<>();
    }

    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<Lotto> lottos = new ArrayList<>();

    for(int i=0; i<manualLottoCount; i++) {
      String input = scanner.nextLine();
      lottos.add(Lotto.of(input));
    }

    return lottos;
  }

  public static void closeScanner() {
    scanner.close();
  }

}
