package lotto.controller;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

  private static final String WINNING_NUMBER_DELIMITER = ", ";

  public static void run() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.getPurchaseAmount());
    int lottoCount = purchaseAmount.getLottoCount();
    Lottos lottos = Lottos.autoCreate(lottoCount);
    ResultView.printLottos(lottos);
    Lotto lastWeekWinningLotto = Lotto.create(splitToSet(InputView.getLastWeekWinningNumber()));
  }

  private static Set<Integer> splitToSet(String value) {
    return Arrays.stream(value.split(WINNING_NUMBER_DELIMITER))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
  }
}
