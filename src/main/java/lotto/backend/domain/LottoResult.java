package lotto.backend.domain;

import java.util.Collections;
import java.util.Map;

public class LottoResult {

    private final LottoStatistics lottoStatistics;
    private final LottoProfit lottoProfit;

    public LottoResult(LottoTicket winningLotto, LottoTickets lottoTickets) {
        this.lottoStatistics = LottoStatistics.of(winningLotto, lottoTickets);
        this.lottoProfit = LottoProfit.of(lottoStatistics.prizeAmount(), lottoTickets.orderAmount());
    }

    public static LottoResult of(LottoTicket winningLotto, LottoTickets lottoTickets) {
        return new LottoResult(winningLotto, lottoTickets);
    }

    public double getProfit() {
        return lottoProfit.getValue();
    }

    public int getPrize() {
        return lottoStatistics.prizeAmount();
    }

    public Map<LottoRank, Integer> getLottoStatistics() {
        return Collections.unmodifiableMap(lottoStatistics.getValues());
    }
}
