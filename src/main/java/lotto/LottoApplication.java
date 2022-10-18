package lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        long paidAmount = InputView.readPurchaseAmount();
        int ticketCount = LottoTicket.getLottoTicketCount(paidAmount);
        Lotto lotto = new Lotto(ticketCount);
        ResultView.printLottoTickets(lotto);

        List<LottoNumber> winningNumbers = InputView.readWinningNumbers();
        lotto.checkWin(winningNumbers);
        ResultView.printWinningStatistics(lotto);

    }

}
