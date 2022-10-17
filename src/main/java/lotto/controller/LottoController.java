package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoPlace;
import lotto.domain.LottoWinners;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  private static LottoController controller;

  public static LottoController getLottoController() {
    if (controller == null) {
      controller = new LottoController();
    }
    return controller;
  }

  public void run() {
    System.out.println("구입금액을 입력해 주세요.");
    Money money = Money.from(InputView.getPrice());
    System.out.printf("%d개를 구매했습니다.\n", money.getLottoCount());

    LottoList lottoList = LottoList.of(money.getLottoCount());
    OutputView.printLottoList(lottoList.getLottoList());

    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    Lotto weekendLotto = Lotto.from(InputView.getWeekendNumbers());

    LottoWinners winners = LottoWinners.of(lottoList.getLottoList(), weekendLotto);

    OutputView.printWinner(winners);

    OutputView.printYield(money.calYield(winners.getTotalPrize()));
  }
}
