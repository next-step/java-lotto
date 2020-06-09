package lotto;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.prize.WinningResult;
import lotto.util.LottoUtil;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.enterPurchaseAmount();

        // 로또 생성
        int quantity = LottoUtil.calculateLottoQuantity(purchaseAmount);
        LottoTicket lottoTicket = LottoTicket.create(quantity);
        ResultView.printLottoTicket(quantity, lottoTicket);

        //당첨번호 입력 및 당첨 결과 출력
        String enteredWinNumber = InputView.enterWinningNumber();
        int enteredBonusBall = InputView.enterBonusBall();

        WinningResult winningResult = lottoTicket.makeWinningResult(enteredWinNumber, enteredBonusBall);
        ResultView.printWinningResult(winningResult);

        //수익율 출력
        double winningRate = winningResult.calculateWinningRate(purchaseAmount);
        ResultView.printWinningRate(winningRate);


    }
}
