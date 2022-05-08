package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGroup;
import lotto.pattern.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoTicketGroup lottoTicketGroup = new LottoTicketGroup(money, new LottoNumberGenerator());

        ResultView.printLottoTicketsCount(lottoTicketGroup);
        ResultView.printLottoTickets(lottoTicketGroup);

        Lotto lotto = new Lotto(new LottoTicket(InputView.getWinnerTicket()));

        ResultView.printWinningStatistics(lotto.compareLotto(lottoTicketGroup), money);
    }
}
