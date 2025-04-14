package lotto;

import lotto.domain.LottoOrder;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoOrder lottoOrder = InputView.createLottoOrder();
        LottoTickets tickets = LottoTicketMachine.purchase(lottoOrder);
        ResultView.showPurchaseResult(tickets);

        WinningNumbers winningTicket = InputView.getWinningTicket();
        LottoResult lottoResult = LottoResult.createLottoResult(winningTicket, tickets);
        ResultView.showStatistics(lottoResult.getLottoRankCount());

        Price totalAmount = lottoOrder.getPurchaseAmount();
        int totalPrizeMoney = lottoResult.calculateTotalPrizeMoney();
        double profitRate = totalAmount.calculateYield(totalPrizeMoney);
        ResultView.showProfitRate(profitRate);
    }

}
