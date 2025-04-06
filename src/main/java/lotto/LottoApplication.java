package lotto;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.getPurchaseAmount();
        LottoTicket[] lottoTickets = LottoTicketMachine.purchase(purchasePrice);
        ResultView.showPurchaseResult(lottoTickets);

        LottoTicket winningTicket = InputView.getWinningTicket();
        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket, lottoTickets);
        ResultView.showStatistics(lottoStatistics);
    }

}
