package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        long paidAmount = InputView.readPurchaseAmount();
        int ticketCount = LottoTicket.getLottoTicketCount(paidAmount);
        Lotto lotto = Lotto.of(ticketCount);
        ResultView.printLottoTickets(lotto);

        List<LottoNumber> winningNumbers = InputView.readWinningNumbers();
        ResultView.printWinningStatistics(lotto.getWinningStat(winningNumbers), lotto);
    }

}
