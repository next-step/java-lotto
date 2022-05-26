package step2;

import step2.domain.Lotto;
import step2.domain.Statistics;
import step2.domain.Ticket;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        int purchase = InputView.getPurchase();

        int cnt = ResultView.countOfTickets(purchase);

        Lotto lotto = new Lotto(cnt);

        //로또 번호 출력
        ResultView.printTickets(lotto);

        //지난주 당첨번호 입력
        String winningStr = InputView.getWinningNum();

        Statistics statistics = lotto.getStatistics(winningStr);

        ResultView.printStatistics(statistics, purchase);
    }


}
