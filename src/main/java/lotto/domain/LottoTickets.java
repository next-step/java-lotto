package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> buyLotto) {
        lottoTickets = buyLotto;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (LottoTicket lottoTicket : lottoTickets) {
            result.append(lottoTicket.toString()).append("\n");
        }

        return result.toString();
    }
}
