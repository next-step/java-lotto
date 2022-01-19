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

    //테스트 코드에서 Lotto 들을 맘대로 넣을 수 없어서 수정
    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public void calculateLottoTotalPrize() {
        for (Lotto lotto : lottoTickets) {
            totalPrize = totalPrize.add(new BigDecimal(Prize.prizes.getOrDefault(lotto.getMatchCount(), 0)));
        }
    }

    public BigDecimal calculateLottoRatio(int purchasePrice) {
        return totalPrize.divide(new BigDecimal(purchasePrice), 2, BigDecimal.ROUND_HALF_UP);
    }

}
