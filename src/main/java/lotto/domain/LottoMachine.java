package lotto.domain;

import java.util.List;

public class LottoMachine {
    private TicketMoney ticketMoney;

    public LottoResult winningResult(LottoTicket winningTicket, LottoTickets lottoTickets) {
        return new LottoResult(winningTicket, lottoTickets);
    }

    public void purchaseTotalTicket(int purchaseAmount) {
        this.ticketMoney = new  TicketMoney(purchaseAmount);
    }

    public int purchaseManualTicket(int manualTicketCount) {
        this.ticketMoney.manualPurchase(manualTicketCount);
        return this.ticketMoney.getManualCount();
    }

    public LottoTickets myTickets(){
        return new LottoTickets(ticketMoney.getAutoCount());
    }

    public LottoTickets myTickets(List<LottoTicket> manualTickets){
        return new LottoTickets(ticketMoney.getAutoCount(), manualTickets);
    }

}
