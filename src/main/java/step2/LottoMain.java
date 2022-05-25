package step2;

import step2.domain.Lotto;
import step2.domain.Ticket;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        int purchase = InputView.getPurchase();

        int cnt = ResultView.countOfTickets(purchase);

        Lotto lotto = new Lotto(cnt);

        String winningStr = InputView.getWinningNum();



    }


}
