package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    private LottoResult(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
        lottoResult = lottoTickets.getMatchRankCount(winningLottoTicket);
    }

    public static LottoResult of(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
        return new LottoResult(lottoTickets, winningLottoTicket);
    }

    public Map<LottoRank, Integer> getLottoResult() {

        return Collections.unmodifiableMap(lottoResult);
    }

    public ProfitRate calculateProfitRate(double purchaseAmount) {

        double totalAmount = lottoResult.keySet().stream()
                .mapToDouble(key -> lottoResult.getOrDefault(key, 0) * key.getPrice())
                .sum();

        return ProfitRate.of(totalAmount / purchaseAmount);
    }
}