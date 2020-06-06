package lotto;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.prize.WinningResult;
import lotto.service.LottoMachine;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        //로또 금액 입력
        int purchaseAmount = InputView.enterPurchaseAmount();

        //로또 기계에서 로또 구매
        LottoMachine lottoMachine = LottoMachine.turnOn();
        LottoTicket lottoTicket = lottoMachine.purchaseLotto(purchaseAmount);

        //당첨번호 입력 및 당첨 결과 출력
        String enteredWinNumber = InputView.enterWinningNumber();
        WinningResult winningResult = WinningResult.create(lottoTicket, enteredWinNumber);
        winningResult.printWinningResult();

        //수익율 출력
        double winningRate = winningResult.calculateWinningRate(purchaseAmount);
        ResultView.printWinningRate(winningRate);


    }
}
