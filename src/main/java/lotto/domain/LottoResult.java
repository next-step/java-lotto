package lotto.domain;

import lotto.LottoRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final int INCREASE_COUNT = 1;
    private final int DEFAULT_COUNT = 0;

    private final Map<LottoRank, Integer> lottoResult;

    private LottoResult(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
        lottoResult = new HashMap<>();

        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            int matchCount = lottoTicket.getMatchCount(winningLottoTicket);
            setRankEnumByMatchCount(matchCount, lottoTicket.contains(bonusLottoNumber));
        }
    }

    public static LottoResult of(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket, LottoNumber bonusLottoNumber) {
        return new LottoResult(lottoTickets, winningLottoTicket, bonusLottoNumber);
    }

    private void setRankEnumByMatchCount(int matchCount, boolean bonusMatch) {
        LottoRank key = LottoRank.valueOf(matchCount, bonusMatch);
        lottoResult.put(key, lottoResult.getOrDefault(key, DEFAULT_COUNT) + INCREASE_COUNT);
    }

    public Map<LottoRank, Integer> getLottoResult() {

        return Collections.unmodifiableMap(lottoResult);
    }

    public double calculateProfitRate(double purchaseAmount) {

        double totalAmount = lottoResult.keySet().stream()
                .mapToDouble(key -> lottoResult.getOrDefault(key, 0) * key.getPrice())
                .sum();

        double profitRate = totalAmount / purchaseAmount;

        return profitRate;
    }
}
