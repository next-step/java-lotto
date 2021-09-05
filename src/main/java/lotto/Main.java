package lotto;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

  public static void main(String[] args) {
    try {
      Money purchaseMoney = InputView.inputMoney();
      long manualLottoCnt = InputView.inputManualLottoCnt(purchaseMoney);
      List<String> manualLottoList = InputView.inputManualLottoList(manualLottoCnt);

      LottoGame lottoGame = new LottoGame(purchaseMoney, manualLottoList);
      ResultView.printPurchasedLottos(lottoGame);

      WinningResult winningResult = lottoGame.winningResult(InputView.winningInfo());
      ResultView.printWinningResult(winningResult);
    } catch (NumberFormatException e) {
      System.err.println("숫자값으로 입력해주세요.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
