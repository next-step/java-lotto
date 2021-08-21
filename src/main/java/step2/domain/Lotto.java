package step2.domain;

public class Lotto {
    private final LottoTickets lottoTickets;
    private final LottoNumbersGenerator lottoNumbersGenerator;
    private final Money money;

    public Lotto(int money) {
        this.money = new Money(money);
        this.lottoTickets = new LottoTickets();
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
        makeLottoTickets();
    }

    public int getTotalLottoTicketCount() {
        return money.getTotalLottoTicketCount();
    }

    public void makeLottoTickets() {
        int makeCount = getTotalLottoTicketCount();

        for (int i = 0; i < makeCount; i++) {
            lottoTickets.addLottoTicket(lottoNumbersGenerator.generateLottoTicket());
        }
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
