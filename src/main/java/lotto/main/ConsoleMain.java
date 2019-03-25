package lotto.main;

import lotto.domain.Lotto;
import lotto.dto.Money;
import lotto.dto.UserLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        //input
        Money money = InputView.inputUserMoney();

        //buy lotto
        Lotto lotto = new Lotto(money);
        lotto.buy();

        //result lotto
        UserLotto userLotto = lotto.getUserLotto();
        ResultView.resultUserTicketCount(userLotto);
        ResultView.resultUserLotto(userLotto);

        lotto.winningLotto(InputView.inputWinningLotto());
        ResultView.resultMatch(lotto.result());
    }
}
