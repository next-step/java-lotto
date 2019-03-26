package lotto.main;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        //input
        InputView.inputUserMoney();

        //buy lotto
        Lotto.buy();

        //result lotto
        ResultView.resultUserTicketCount();
        ResultView.resultUserLotto();
        Lotto.winningLotto(InputView.inputWinningLotto());
        Lotto.createLottoMatch();
        ResultView.resultMatch();
    }
}
