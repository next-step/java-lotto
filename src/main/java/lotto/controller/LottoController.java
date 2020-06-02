package lotto.controller;

import java.util.Scanner;
import lotto.model.Lotto;
import lotto.model.LottoFactory;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistics;
import lotto.view.LottoView;

public class LottoController {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    LottoView.printPurchaseRequestMsg();

    Lotto lotto = LottoFactory.createLottoByQuickPick(new Money(scanner.nextInt()));
    scanner.nextLine();

    LottoView.printPurchaseDoneMsg(lotto.getLottoList().size());

    LottoView.printLottoNumbers(lotto);

    LottoView.printWinningNumberRequestMsg();

    WinningNumbers winningNumbers = WinningNumbers
        .newInstanceByStrArr(scanner.nextLine().split(","));

    LottoView.printStatisticsMsg();

    WinningStatistics winningStatistics = WinningStatistics
        .newInstanceFromLottoAndWinningNumbers(lotto, winningNumbers);

    LottoView.printPrizeTierCnt(winningStatistics.getPrizeTierCntMap());

    LottoView.printProfitRate(winningStatistics.getProfitRate());
  }
}
