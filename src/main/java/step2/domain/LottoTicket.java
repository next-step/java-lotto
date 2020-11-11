package step2.domain;

public class LottoTicket {


    private final int lottoTickets;

    public LottoTicket(int money) {
        this.lottoTickets = money/1000;
    }

    public int getLottoTicketCount() {
        return lottoTickets;
    }
}
