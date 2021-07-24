package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoMachine;
import lotto.money.Money;
import lotto.number.WinningNumbers;
import lotto.prize.MatchResult2;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoConsoleGame {

    public static void main(String[] args) {
        Money payment = InputView.inputPayment();

        Lotto lotto = LottoMachine.buy(payment);
        ResultView.printLottoTickets(lotto.getLottoTickets());

        WinningNumbers winningNumbers = InputView.inputWinningNumbers();
        MatchResult2 matchResult = lotto.match(winningNumbers);

        ResultView.printMatchResult(matchResult);
    }

}
