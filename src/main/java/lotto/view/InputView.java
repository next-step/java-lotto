package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.WinningLotto;

public class InputView {

  private Scanner scanner = new Scanner(System.in);

  public int getPurchaseAmount() {
    System.out.println("구입 금액을 입력해 주세요.");
    int purchaseAmount = scanner.nextInt();
    return purchaseAmount;
  }

  public WinningLotto getWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    scanner.nextLine();
    return new WinningLotto(getLottoNumbers(), getBonusBall());
  }

  private List<Integer> getLottoNumbers() {
    return Arrays.stream(scanner.nextLine().split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public int getBonusBall() {
    System.out.println("보너스 볼을 입력해 주세요.");
    int bonusBall = scanner.nextInt();
    return bonusBall;
  }
}
