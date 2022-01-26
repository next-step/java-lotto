package domain;

import java.math.BigDecimal;
import java.util.*;

public class LottoTickets {
    private final List<Lotto> lottoTickets;
    private BigDecimal totalPrize;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
        this.totalPrize = BigDecimal.ZERO;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public void calculateLottoTotalPrize() {
        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.getMatchCount();
            totalPrize = totalPrize.add(new BigDecimal(Rank.getRank(matchCount).getPrize()));
        }
    }

    public BigDecimal calculateLottoRatio(int purchasePrice) {
        return totalPrize.divide(new BigDecimal(purchasePrice), 2, BigDecimal.ROUND_HALF_UP);
    }

}
