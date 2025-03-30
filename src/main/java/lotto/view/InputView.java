package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
      throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
    }
  }

  public List<LottoNumber> receiveManualNumbers() {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    return receiveLottoNumbers();
  }

  public List<LottoNumber> receiveWinningLottoNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해주세요.");
    return receiveLottoNumbers();
  }

  private List<LottoNumber> receiveLottoNumbers() {
    String input = scanner.nextLine();
    return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(num -> new LottoNumber(Integer.parseInt(num)))
            .collect(Collectors.toList());
  }

  public LottoNumber receiveBonusNumber() {
    System.out.println("보너스 볼을 입력해주세요.");
    try {
      int money = Integer.parseInt(scanner.nextLine().trim());
      return new LottoNumber(money);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
    }
  }
}
