package lotto.lotto;

public class Lotto {
    private final int payment;
    private final LottoTickets lottoTickets;

    public Lotto(int payment, LottoTickets lottoTickets) {
        this.payment = payment;
        this.lottoTickets = lottoTickets;
    }

    public static Lotto init(int payment, LottoTickets lottoTickets) {
        return new Lotto(payment, lottoTickets);
    }
}
