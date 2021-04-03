package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoCounts;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.exception.LottoException;
import lotto.io.InputView;
import lotto.io.Printer;

public final class LottoManager {

  public static void main(String[] args) {
    Money userMoney = getMoney();
    LottoCount lottoCount = new LottoCount(userMoney);
    Printer.printBlankLine();

    LottoCount manualCount = getManualCount();
    LottoCounts lottoCounts = new LottoCounts(lottoCount, manualCount);
    Printer.printBlankLine();

    Lottos userLottos = new Lottos(lottoCount);
    userLottos.addLottoList(getManualLottoList(manualCount));
    userLottos.addLottoList(lottoCounts.automaticLottos());
    Printer.printBlankLine();

    Printer.printLottoCount(userLottos, manualCount);
    Printer.printLottos(userLottos);

    WinningLotto winningLotto = getWinningLotto();
    WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
    Printer.printRank(winningStatistics);
    Printer.printResult(winningStatistics, userMoney);
  }

  private static Money getMoney() {
    try {
      return new Money(InputView.inputMoney());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getMoney();
    }
  }

  private static LottoCount getManualCount() {
    try {
      return new LottoCount(InputView.inputManualCount());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getManualCount();
    }
  }

  private static List<Lotto> getManualLottoList(LottoCount manualCount) {
    List<Lotto> manualLottoList = new ArrayList<>();
    for (int i = 0; i < manualCount.toInteger(); i++) {
      manualLottoList.add(getManualLotto());
    }
    return manualLottoList;
  }

  private static Lotto getManualLotto() {
    try {
      return new Lotto(InputView.inputManualLotto());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getManualLotto();
    }
  }

  private static WinningLotto getWinningLotto() {
    try {
      return new WinningLotto(getWinningNumberLotto(), getBonusNumber());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getWinningLotto();
    }
  }

  private static LottoNumber getBonusNumber() {
    try {
      return LottoNumber.valueOf(InputView.inputBonusNumber());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getBonusNumber();
    }
  }

  private static Lotto getWinningNumberLotto() {
    try {
      return new Lotto(InputView.inputWinningNumberLotto());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getWinningNumberLotto();
    }
  }
}
