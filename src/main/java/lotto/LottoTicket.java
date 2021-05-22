package lotto;

import java.util.List;

public class LottoTicket {
    private List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public int lottoTicketSize() {
        return lottoTicket.size();
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoTicket=" + lottoTicket +
                '}';
    }
}
