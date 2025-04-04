package lotto;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasePrice purchaseAmount = InputView.getPurchaseAmount();
        LottoTicket[] lottoTickets = LottoTicketMachine.purchase(purchaseAmount.getValue());
        ResultView.showPurchaseResult(lottoTickets);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers.getInputNumbers());
        LottoResult lottoResult = new LottoResult(winningTicket, lottoTickets);
        ResultView.showStatistics(lottoResult.calculateStatistics(), lottoResult.calculateProfitRate());
    }

}
