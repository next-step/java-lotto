package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class InputView {

  private static final String LOTTO_NUMBER_DELIMITER = ", ";
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

  public static List<Lotto> getManualLottos(int lottoCount) {
    int manualLottoCount = getManualLottoCount();
    validateCount(lottoCount, manualLottoCount);
    return getManualLottoInputs(manualLottoCount).stream()
        .map(s -> Arrays.asList(s.split(LOTTO_NUMBER_DELIMITER)))
        .map(Lotto::manualCreate)
        .collect(Collectors.toList());
  }

  public static int getManualLottoCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static List<String> getManualLottoInputs(int count) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<String> inputs = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      inputs.add(SCANNER.nextLine());
    }
    return inputs;
  }

  private static Lotto getLastWeekLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String[] stringNumbers = SCANNER.nextLine().split(LOTTO_NUMBER_DELIMITER);
    return Lotto.create(Arrays.stream(stringNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toSet()));
  }

  private static LottoNumber getLastWeekBonus() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return new LottoNumber(Integer.parseInt(SCANNER.nextLine()));
  }

  private static void validateCount(int lottoCount, int manualLottoCount) {
    if (lottoCount < manualLottoCount) {
      throw new IllegalArgumentException("수동 로또 갯수가 전체 로또 갯수보다 클 수 없습니다.");
    }
  }
}
