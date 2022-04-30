package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

  public static void run() {
    PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
    int lottoCount = purchaseAmount.getLottoCount();

    List<Lotto> manualLottos = getManualLottos(lottoCount);
    Lottos lottos = Lottos.create(manualLottos, lottoCount);
    ResultView.printLottos(lottos);

    WinningLotto lastWeekWinningLotto = InputView.getLastWeekWinningLotto();

    LottoResult result = lottos.calculate(lastWeekWinningLotto);
    ResultView.printResult(result, result.calculateYield(purchaseAmount));
  }

  private static List<Lotto> getManualLottos(int lottoCount) {
    int manualLottoCount = InputView.getManualLottoCount();
    validateCount(lottoCount, manualLottoCount);
    List<String> manualInput = InputView.getManualLottoInput(manualLottoCount);
    return manualInput.stream()
        .map(Lotto::manualCreate)
        .collect(Collectors.toList());
  }

  private static void validateCount(int lottoCount, int manualLottoCount) {
    if (lottoCount < manualLottoCount) {
      throw new IllegalArgumentException("수동 로또 갯수가 전체 로또 갯수보다 클 수 없습니다.");
    }
  }
}
