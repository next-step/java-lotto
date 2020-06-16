package lotto;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.prize.WinningLotto;
import lotto.domain.prize.WinningResult;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.util.LottoUtil;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.enterPurchaseAmount();
        int quantity = LottoUtil.calculateLottoQuantity(purchaseAmount);

        int manualCount = InputView.enterManualCount();
        List<String> manualNumber = InputView.enterManualNumbers(quantity, manualCount);

        //로또 생성
        LottoTicket lottoTicket = LottoTicket.create(quantity, manualNumber);
        ResultView.printLottoTicket(quantity, manualCount, lottoTicket);

        //당첨번호, 보너스볼 입력
        String enteredWinNumber = InputView.enterWinningNumber();
        int enteredBonusBall = InputView.enterBonusBall();

        //당첨 결과 출력
        WinningLotto winningLotto = WinningLotto.create(enteredWinNumber, enteredBonusBall);
        WinningResult winningResult = winningLotto.makeWinningResult(lottoTicket);
        ResultView.printWinningResult(winningResult);

        //수익율 출력
        double winningRate = winningResult.calculateWinningRate(purchaseAmount);
        ResultView.printWinningRate(winningRate);


    }
}
