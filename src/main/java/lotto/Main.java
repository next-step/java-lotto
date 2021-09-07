package lotto;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.WinningInfo;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

  public static void main(String[] args) {
    try {
      Money purchaseMoney = new Money(InputView.inputMoney());
      long manualLottoCnt = InputView.inputManualLottoCnt(purchaseMoney);
      List<String> manualLottoList = InputView.inputManualLottoList(manualLottoCnt);

      LottoGame lottoGame = new LottoGame(purchaseMoney, manualLottoList);
      ResultView.printPurchasedLottos(lottoGame);

      LottoNumbers winningLottoNumbers = new LottoNumbers(InputView.winningLottoNumbers());
      LottoNumber bonusLottoNumber = LottoNumber.valueOf(InputView.bonusLottoNumber());
      WinningInfo winningInfo = new WinningInfo(winningLottoNumbers, bonusLottoNumber);

      WinningResult winningResult = lottoGame.winningResult(winningInfo);
      ResultView.printWinningResult(winningResult);

    } catch (NumberFormatException e) {
      System.err.println("숫자값으로 입력해주세요.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
