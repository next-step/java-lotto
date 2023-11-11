package lotto.step2.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> rankResult;

    public LottoResults() {
        rankResult = new EnumMap<>(LottoRank.class);
    }

    public int getCount(final LottoRank lottoRank) {
        return rankResult.getOrDefault(lottoRank, 0);
    }

    public void incrementRankCount(final LottoRank lottoRank) {
        rankResult.put(lottoRank, getCount(lottoRank) + 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<LottoRank, Integer> entry : rankResult.entrySet()) {
            final LottoRank lottoRank = entry.getKey();

            String numberMatchCountText = lottoRank.getMatchingCount() + "개 일치";
            String priceText = lottoRank.getPrizeMoney() + "원";
            String rankCountText = entry.getValue() + "개";

            sb.append(numberMatchCountText).append(" ")
                    .append("(").append(priceText).append(")")
                    .append("- ").append(rankCountText).append("\n");
        }

        return sb.toString();
    }

    public long getTotalPrizeMoney() {
        return (long) LottoRank.FIRST.getPrizeMoney() * getCount(LottoRank.FIRST)
                + (long) LottoRank.SECOND.getPrizeMoney() * getCount(LottoRank.SECOND)
                + (long) LottoRank.THIRD.getPrizeMoney() * getCount(LottoRank.THIRD)
                + (long) LottoRank.FOURTH.getPrizeMoney() * getCount(LottoRank.FOURTH);
    }
}
