package lotto.view;

import lotto.domain.LottoNumber;
import lotto.utils.LottoNumberParser;
import lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public PurchaseAmount receiveMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    try {
      int money = Integer.parseInt(scanner.nextLine().trim());
      return new PurchaseAmount(money);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("구매 금액은 숫자여야 합니다.");
    }
  }

  public List<String> receiveManualLottos() {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");

    List<String> manualLottoNumberList = new ArrayList<>();

    while (true) {
      String input = scanner.nextLine();
      if (input.isEmpty()) {
        break;
      }
      manualLottoNumberList.add(input);
    }
    return manualLottoNumberList;
  }

  public List<LottoNumber> receiveWinningLottoNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해주세요.");
    String input = scanner.nextLine();
    return LottoNumberParser.parse(input);
  }

  public LottoNumber receiveBonusNumber() {
    System.out.println("보너스 볼을 입력해주세요.");
    try {
      int money = Integer.parseInt(scanner.nextLine().trim());
      return new LottoNumber(money);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
    }
  }
}
