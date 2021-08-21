package step2.domain;

public class Lotto {
    private final LottoTickets lottoTickets;
    private final AutoLottoNumbersGenerator lottoNumbersGenerator;
    private final Money money;

    public Lotto(int money) {
        this.money = new Money(money);
        this.lottoTickets = new LottoTickets();
        this.lottoNumbersGenerator = new AutoLottoNumbersGenerator();
        makeLottoTickets();
    }

    public int getTotalLottoTicketCount() {
        return money.getTotalLottoTicketCount();
    }

    private void makeLottoTickets() {
        int makeCount = getTotalLottoTicketCount();

        for (int i = 0; i < makeCount; i++) {
            lottoTickets.addLottoTicket(lottoNumbersGenerator);
        }
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
