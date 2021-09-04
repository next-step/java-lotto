package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.WinningInfo;
import lotto.exception.ExceedPurchaseCountException;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static Money inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Money(Integer.parseInt(scanner.nextLine()));
  }

  public static long inputManualLottoCnt(Money money) {
    System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    long manualLottoCnt = Integer.parseInt(scanner.nextLine());
    if (manualLottoCnt > LottoGame.purchaseCnt(money)) {
      throw new ExceedPurchaseCountException();
    }
    return manualLottoCnt;
  }

  public static List<Lotto> inputManualLottoList(long manualLottoCnt) {
    System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    List<Lotto> manualLottoList = new ArrayList<>();
    for (int i = 0; i < manualLottoCnt; i++) {
      String input = scanner.nextLine();
      List<Integer> numbers = Arrays.stream(input.split(","))
          .map(String::trim)
          .map(Integer::valueOf)
          .collect(Collectors.toList());
      manualLottoList.add(Lotto.issueByManual(numbers));
    }
    return manualLottoList;
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
