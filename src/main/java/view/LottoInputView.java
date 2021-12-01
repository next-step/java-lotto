package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.Lottos;
import domain.Wallet;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static common.Constants.DELIMITER;

public class LottoInputView {

  public static int inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public static int inputCustomLottoCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public static void inputCustomLottoNumbers(int count, Wallet wallet) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    Lottos customLottos = new Lottos();
    for(int i = 0; i < count; i++) {
      buyCustomLotto(customLottos);
    }
    wallet.buyCustomLottos(customLottos);
  }

  private static void buyCustomLotto(Lottos customLottos) {
    final List<LottoNumber> lottoNumbers = Arrays.stream(new Scanner(System.in).nextLine()
            .split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    customLottos.addLotto(new Lotto(lottoNumbers));
  }

  public static List<LottoNumber> inputLastWeekWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력 해 주세요");
    String lastWeekWinningNumbers = new Scanner(System.in).nextLine();
    System.out.println(lastWeekWinningNumbers);
    return Stream.of(lastWeekWinningNumbers.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
  }

  public static int inputLastWeekBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    int lastWeekBonusNumber = new Scanner(System.in).nextInt();
    System.out.println(lastWeekBonusNumber);
    return lastWeekBonusNumber;
  }

}
