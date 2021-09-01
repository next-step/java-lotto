package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.WinningInfo;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static Money inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Money(Integer.parseInt(scanner.nextLine()));
  }

  public static WinningInfo winningInfo() {
    return new WinningInfo(winningLottoNumbers(), bonusLottoNumber());
  }

  private static LottoNumbers winningLottoNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = scanner.nextLine();
    List<LottoNumber> lottoNumbers = Arrays.stream(input.split(","))
        .map(String::trim)
        .map(Integer::valueOf)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList());
    return new LottoNumbers(lottoNumbers);
  }

  private static LottoNumber bonusLottoNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    int number = Integer.parseInt(scanner.nextLine().trim());
    return LottoNumber.valueOf(number);
  }
}
