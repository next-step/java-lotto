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
import lotto.exception.LottoException;
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
    Money userMoney = getMoney(inputView);
    LottoCount lottoCount = new LottoCount(userMoney);
    Printer.printBlankLine();

    LottoCount manualCount = getManualCount(inputView);
    LottoCounts lottoCounts = new LottoCounts(lottoCount, manualCount);
    Printer.printBlankLine();

    Lottos userLottos = new Lottos(lottoCount);
    userLottos.addLottoList(getManualLottoList(inputView, manualCount));
    userLottos.addLottoList(lottoCounts.automaticLottos());
    Printer.printBlankLine();

    Printer.printLottoCount(userLottos, manualCount);
    Printer.printLottos(userLottos);

    WinningLotto winningLotto = getWinningLotto(inputView);
    WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
    Printer.printRank(winningStatistics);
    Printer.printResult(winningStatistics, userMoney);
  }

  private static Money getMoney(InputView inputView) {
    try {
      return new Money(inputView.inputMoney());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getMoney(inputView);
    }
  }

  private static LottoCount getManualCount(InputView inputView) {
    try {
      return new LottoCount(inputView.inputManualCount());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getManualCount(inputView);
    }
  }

  private static List<Lotto> getManualLottoList(InputView inputView, LottoCount manualCount) {
    List<Lotto> manualLottoList = new ArrayList<>();
    for (int i = 0; i < manualCount.toInteger(); i++) {
      manualLottoList.add(getManualLotto(inputView));
    }
    return manualLottoList;
  }

  private static Lotto getManualLotto(InputView inputView) {
    try {
      return new Lotto(inputView.inputManualLotto());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getManualLotto(inputView);
    }
  }

  private static WinningLotto getWinningLotto(InputView inputView) {
    try {
      return new WinningLotto(getWinningNumberLotto(inputView), getBonusNumber(inputView));
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getWinningLotto(inputView);
    }
  }

  private static LottoNumber getBonusNumber(InputView inputView) {
    try {
      return LottoNumber.valueOf(inputView.inputBonusNumber());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getBonusNumber(inputView);
    }
  }

  private static Lotto getWinningNumberLotto(InputView inputView) {
    try {
      return new Lotto(inputView.inputWinningNumberLotto());
    } catch (LottoException e) {
      System.err.println(e.getMessage());
      return getWinningNumberLotto(inputView);
    }
  }
}
