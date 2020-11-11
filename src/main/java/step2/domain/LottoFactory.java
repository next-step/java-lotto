package step2.domain;

public class LottoFactory {


    private final int lottoTickets;

    public LottoFactory(int money) {
        this.lottoTickets = money/1000;
    }

    public int getLottoTicketCount() {
        return lottoTickets;
    }
}
