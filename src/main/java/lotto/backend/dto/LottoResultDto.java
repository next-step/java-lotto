package lotto.backend.dto;

import lotto.backend.domain.LottoRank;
import lotto.backend.domain.LottoResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResultDto {

    private final Map<LottoRank, Integer> ranking = new EnumMap<>(LottoRank.class);
    private final double profit;

    public LottoResultDto(Map<LottoRank, Integer> rank, double profit) {
        rankingConvertor(rank);
        this.profit = profit;
    }

    private void rankingConvertor(Map<LottoRank, Integer> ranks) {
        Arrays.stream(LottoRank.values())
                .filter(this::isWinning)
                .forEach(rank -> ranking.put(rank, ranks.getOrDefault(rank, 0)));
    }

    private boolean isWinning(LottoRank rank) {
        return rank != LottoRank.NOTHING;
    }

    public static LottoResultDto of(LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getLottoStatistics(), lottoResult.getProfit());
    }

    public double getProfit() {
        return profit;
    }

    public Map<LottoRank, Integer> getRanking() {
        return Collections.unmodifiableMap(ranking);
    }
}
