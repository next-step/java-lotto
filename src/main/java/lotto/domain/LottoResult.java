package lotto.domain;

import lotto.LottoRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final int INCREASE_COUNT = 1;
    private final int DEFAULT_COUNT = 0;

    private final Map<LottoRank, Integer> lottoResult;

    private LottoResult(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
        lottoResult = new HashMap<>();

        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            LottoRank rank = winningLottoTicket.match(lottoTicket);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, DEFAULT_COUNT) + INCREASE_COUNT);
        }
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