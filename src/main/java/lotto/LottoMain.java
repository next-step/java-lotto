package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        Lotto lotto = new Lotto(amount);
        ResultView.printTicketCount(lotto.getTicketCount());
        ResultView.printTickeList(lotto.getTicketList());
    }
}
