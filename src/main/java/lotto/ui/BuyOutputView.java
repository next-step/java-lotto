package lotto.ui;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.List;

public class BuyOutputView {
    private LottoTickets lottoTickets;

    public BuyOutputView(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public String convertToString() {
        List<LottoTicket> values = lottoTickets.getValues();
        return values.stream()
                .map(LottoTicket::toString)
                .reduce((a, b) -> a + "\n" + b)
                .get();
    }
}
