package lotto.controller;

import java.util.Scanner;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.LottoFactory;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
import lotto.view.LottoView;

public class LottoController {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    LottoView.printPurchaseRequestMsg();
    int purchaseQuantity = (int) (new Money(scanner.nextInt()).getValue() / Lotto.PRICE.getValue());
    LottoView.printPurchaseDoneMsg(purchaseQuantity);

    LottoView.printManualPurchaseNumberRequestMsg();
    int manualQuantity = scanner.nextInt();
    String[] numberStrArr = new String[manualQuantity];
    scanner.nextLine();

    LottoView.printManualPurchaseRequestMsg();
    for (int i = 0; i < numberStrArr.length; i++) {
      numberStrArr[i] = scanner.nextLine();
    }

    Lottos quickPickedLottos = LottoFactory
        .createLottosByQuickPick(purchaseQuantity - manualQuantity);
    Lottos manualPickedLottos = LottoFactory.createLottosByManual(numberStrArr);

    LottoView.printLottoNumbers(quickPickedLottos, manualPickedLottos);

    LottoView.printWinningNumberRequestMsg();
    String[] winningNumberArr = scanner.nextLine().split(",");

    LottoView.printWinningBonusNumberRequestMsg();
    LottoNumber bonusNumber = new LottoNumber(scanner.nextInt());
    WinningLotto winningLotto = WinningLotto.newInstanceByStrArr(winningNumberArr, bonusNumber);

    LottoView.printStatisticsMsg();
    WinningStatistics winningStatistics = WinningStatistics
        .newInstanceFromLottoAndWinningNumbers(
            Lottos.of(quickPickedLottos, manualPickedLottos), winningLotto);

    LottoView.printPrizeTierCnt(winningStatistics.getPrizeTierCntMap());

    LottoView.printProfitRate(winningStatistics.getProfitRate());
  }
}
