package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class InputView {

  private static final String WINNING_NUMBER_DELIMITER = ", ";
  private static Scanner SCANNER = new Scanner(System.in);

  private InputView() {
  }

  public static PurchaseAmount getPurchaseAmount() {
    System.out.println("구매 금액을 입력해주세요.");
    return new PurchaseAmount(Integer.parseInt(SCANNER.nextLine()));
  }

  public static WinningLotto getLastWeekWinningLotto() {
    return new WinningLotto(getLastWeekLotto(), getLastWeekBonus());
  }

  private static Lotto getLastWeekLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String[] stringNumbers = SCANNER.nextLine()
        .trim()
        .split(WINNING_NUMBER_DELIMITER);
    return Lotto.create(Arrays.stream(stringNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toSet()));
  }

  private static LottoNumber getLastWeekBonus() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return new LottoNumber(Integer.parseInt(SCANNER.nextLine()));
  }
}
