package lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoTicket[] lottoTickets = LottoTicketMachine.purchase(purchaseAmount);
        ResultView.showPurchaseResult(lottoTickets);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers);
        LottoResult lottoResult = new LottoResult(winningTicket, lottoTickets);
        ResultView.showStatistics(lottoResult.calculateStatistics(), lottoResult.calculateProfitRate());
    }

}
