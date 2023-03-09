package lotto.ui;

import lotto.domain.enums.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final Map<LottoRank, Integer> ranks;
    private final BigDecimal buyingPrice;

    public LottoResult(Map<LottoRank, Integer> ranks, int buyingPrice) {
        this.ranks = ranks;
        this.buyingPrice = new BigDecimal(buyingPrice);
    }

    public int findHitCount(final LottoRank rank) {
        return ranks.getOrDefault(rank, 0);
    }

    public void printWinningStatistics() {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(LottoRank.values())
                .forEach(rank -> {
                    String result = createResult(ranks, rank);
                    sb.append(result).append("\n");
                });

        BigDecimal totalRate = calculateTotalRate(ranks);
        sb.append("총 수익률은 ").append(totalRate).append("% 입니다.").append("\n");
        System.out.println(sb);
    }

    private String createResult(Map<LottoRank, Integer> ranks, LottoRank rank) {
        Integer integer = ranks.get(rank);
        int count = 0;
        if (integer != null) {
            count = integer;
        }
        return String.format("%s- %d개", rank, count);
    }

    public BigDecimal calculateTotalRate(Map<LottoRank, Integer> ranks) {
        int sum = 0;

        Set<LottoRank> lottoRanks = ranks.keySet();

        for (LottoRank lottoRank : lottoRanks) {
            int hitCount = ranks.get(lottoRank);
            int rewarding = lottoRank.getRewarding();
            sum += rewarding * hitCount;
        }

        BigDecimal totalRewarding = new BigDecimal(sum);
        return totalRewarding.divide(buyingPrice, 2, RoundingMode.DOWN);
    }
}
