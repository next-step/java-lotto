package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;
    private final BigDecimal purchasePrice;

    public LottoTickets(List<LottoTicket> lottoTickets, int purchasePrice) {
        this.lottoTickets = lottoTickets;
        this.purchasePrice = BigDecimal.valueOf(purchasePrice);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<Integer> getCountOfMatchList(LottoTicket lottoTicket) {
        return lottoTickets.stream()
                .map(l -> l.getCountOfMatch(lottoTicket))
                .collect(Collectors.toList());
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }
}
