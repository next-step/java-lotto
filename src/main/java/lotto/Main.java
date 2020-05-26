package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
        ManualLottoCount manualLottoCount = InputView.getManualLottoCount(purchaseAmount);
        ManualNumbers manualNumbers = InputView.getManualNumbers(manualLottoCount);

        LottoGame lottoGame = new LottoGame(purchaseAmount, manualNumbers);
        LottoNumbers lottoNumbers = lottoGame.createLottoNumbers();

        ResultView.printPurchaseCount(lottoNumbers);
        ResultView.printLottoNumbers(lottoNumbers.toList());

        LottoNumber lastWinLottoNumber = LottoNumber.newInstance(InputView.getLastWeekLottoNumbers());
        BonusNumber bonusNumber = InputView.getBonusNumber(lastWinLottoNumber);

        LottoMatchResult lottoMatchResult = lottoGame.calculateMatchCount(lastWinLottoNumber, bonusNumber);
        ResultView.printMatchResult(lottoMatchResult);
        ResultView.printProfitRate(lottoMatchResult, purchaseAmount);
    }
}
