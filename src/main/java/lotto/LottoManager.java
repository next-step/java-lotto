package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoCounts;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.io.InputView;
import lotto.io.Printer;

public final class LottoManager {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      InputView inputView = new InputView(scanner);
      start(inputView);
    }
  }

  private static void start(InputView inputView) {
    Money userMoney = new Money(inputView.inputMoney());
    LottoCount lottoCount = new LottoCount(userMoney);
    Printer.printBlankLine();

    LottoCount manualCount = new LottoCount(inputView.inputManualCount());
    LottoCounts lottoCounts = new LottoCounts(lottoCount, manualCount);
    Printer.printBlankLine();

    Lottos userLottos = new Lottos(lottoCount);
    userLottos.addLottoList(inputManualLottoNumbers(inputView, manualCount));
    userLottos.addLottoList(lottoCounts.automaticLottos());
    Printer.printBlankLine();

    Printer.printLottoCount(userLottos, manualCount);
    Printer.printLottos(userLottos);

    WinningLotto winningLotto = new WinningLotto(new Lotto(inputView.inputWinningLotto()),
        LottoNumber.valueOf(inputView.inputBonusNumber()));
    WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
    Printer.printRank(winningStatistics);
    Printer.printResult(winningStatistics, userMoney);
  }

  private static List<Lotto> inputManualLottoNumbers(InputView inputView, LottoCount manualCount) {
    Printer.printInputManualNumber();
    List<Lotto> manualLottoList = new ArrayList<>();
    for (int i = 0; i < manualCount.toInteger(); i++) {
      manualLottoList.add(new Lotto(inputView.inputWinningLotto()));
    }
    return manualLottoList;
  }
}
