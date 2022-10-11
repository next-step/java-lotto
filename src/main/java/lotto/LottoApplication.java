package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        long paidAmount = InputView.readPurchaseAmount();
        int ticketCount = LottoTicket.getLottoTicketCount(paidAmount);
        Lotto lotto = new Lotto(ticketCount);

        List<Integer> winningNumbers = InputView.readWinningNumbers();
        lotto.checkWin(winningNumbers);

    }

}
