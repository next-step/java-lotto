package lotto;

import java.util.List;
import java.util.Scanner;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoCounts;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.io.InputView;
import lotto.io.Printer;

public final class LottoManager {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      InputView inputView = new InputView(scanner);

      Money userMoney = new Money(inputView.inputMoney());
      long lottoCount = userMoney.divideBy(Lottos.PRICE).toInteger();
      System.out.println();

      long manualCount = inputView.inputManualCount();
      LottoCounts lottoCounts = new LottoCounts(new LottoCount(lottoCount), new LottoCount(manualCount));
      System.out.println();

      Lottos userLottos = new Lottos(lottoCount);
      List<Lotto> manualLottos = inputView.inputManualLottoNumber(manualCount);
      userLottos.addLottoList(manualLottos);
      userLottos.addLottoList(lottoCounts.automaticLottos());
      System.out.println();

      Printer.printLottoCount(userLottos, manualCount);
      Printer.printLottos(userLottos);

      WinningLotto winningLotto = inputView.inputLastWinningNumber();
      WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
      Printer.printRank(winningStatistics);
      Printer.printResult(winningStatistics, userMoney);
    }
  }
}
