package lotto.main;

import lotto.domain.Lotto;
import lotto.dto.Money;
import lotto.rule.LottoSetUp;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        //input
        Money money = InputView.inputUserMoney();

        //buy lotto
        LottoSetUp.setUpLottoRule(6, 45, 1000);
        Lotto lotto = new Lotto(money);
        lotto.buy();

        //result lotto
        ResultView.resultUserLotto(lotto.getUserLotto());
        lotto.winningLotto(InputView.inputWinningLotto());
        ResultView.resultMatch(lotto.result());
    }
}
