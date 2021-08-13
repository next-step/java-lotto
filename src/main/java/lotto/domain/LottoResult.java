package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<LottoRank, Long> lottoResult;

    private LottoResult(Map<LottoRank, Long> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static LottoResult of(Map<LottoRank, Long> lottoResult) {
        return new LottoResult(lottoResult);
    }

    public static LottoResult of(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
         return new LottoResult(lottoTickets.getMatchRankCount(winningLottoTicket).getLottoResult());
    }

    public Map<LottoRank, Long> getLottoResult() {

        return Collections.unmodifiableMap(lottoResult);
    }

    public ProfitRate calculateProfitRate(LottoPrice lottoPrice) {

        double totalAmount = lottoResult.keySet().stream()
                .mapToDouble(key -> lottoResult.getOrDefault(key, 0L) * key.getPrice())
                .sum();

        return ProfitRate.of(lottoPrice.getRatio(totalAmount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult);
    }
}