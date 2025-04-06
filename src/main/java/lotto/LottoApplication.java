package lotto;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.getPurchaseAmount();
        LottoTicket[] lottoTickets = LottoTicketMachine.purchase(purchasePrice);
        ResultView.showPurchaseResult(lottoTickets);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers.getNumbers());
        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket, lottoTickets);
        ResultView.showStatistics(lottoStatistics);
    }

}
