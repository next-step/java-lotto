package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoMachine;
import lotto.lotto.LottoTickets;
import lotto.money.Money;
import lotto.money.PaymentInfo;
import lotto.number.WinningNumbers;
import lotto.prize.MatchResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public final class LottoConsoleGame {

    public static void main(String[] args) {
        Money payment = InputView.inputPayment();
        LottoTickets manualLottoTickets = InputView.inputManualLottoTickets();
        PaymentInfo paymentInfo = PaymentInfo.of(payment, manualLottoTickets);

        Lotto lotto = LottoMachine.buy(paymentInfo, manualLottoTickets);
        ResultView.printBuyInfo(lotto.paymentInfo());
        ResultView.printLottoTickets(lotto.getLottoTickets());

        WinningNumbers winningNumbers = InputView.inputWinningNumbers();
        MatchResult matchResult = lotto.match(winningNumbers);

        ResultView.printMatchResult(matchResult);
    }

}
