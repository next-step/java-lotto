package step2.lotto;

import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1_000;

    private final List<LottoTicket> lottoTickets;

    LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int numberOfTickets() {
        return lottoTickets.size();
    }

    public void print(OutputView outputView) {
        lottoTickets.forEach(lottoTicket -> lottoTicket.print(outputView));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }

}

