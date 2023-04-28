package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  private static final Scanner sc = new Scanner(System.in);

  public static Money getPurchaseAmount() {
    System.out.println("구입 금액을 입력해 주세요.");
    return new Money(Integer.parseInt(sc.nextLine()));
  }

  public static LottoNumbers getLastWeekWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return new LottoNumbers(Arrays.stream(sc.nextLine().split(", "))
                                  .map(LottoNumber::from)
                                  .collect(Collectors.toList())
    );
  }

  public static LottoNumber getBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return LottoNumber.from(sc.nextLine());
  }
}
