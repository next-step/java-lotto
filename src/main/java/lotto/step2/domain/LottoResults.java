package lotto.step2.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoResults {
    private final Map<LottoRank, Integer> rankResult;

    public LottoResults() {
        rankResult = new EnumMap<>(LottoRank.class);

        for (LottoRank lottoRank : LottoRank.values()) {
            rankResult.put(lottoRank, 0);
        }
    }

    public int getCount(final LottoRank lottoRank) {
        return rankResult.getOrDefault(lottoRank, 0);
    }

    public void incrementRankCount(final LottoRank lottoRank) {
        rankResult.put(lottoRank, getCount(lottoRank) + 1);
    }

    @Override
    public String toString() {
        return generateStringUsingEntries(getRankResultEntriesExceptOther());
    }

    private String generateStringUsingEntries(final List<Map.Entry<LottoRank, Integer>> rankResultEntriesExceptOther) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<LottoRank, Integer> entry : rankResultEntriesExceptOther) {
            final LottoRank lottoRank = entry.getKey();

            String rankCountText = String.format("%d개", entry.getValue());

            sb.append(lottoRank).append(rankCountText).append("\n");
        }

        return sb.toString();
    }

    private List<Map.Entry<LottoRank, Integer>> getRankResultEntriesExceptOther() {
        return rankResult.entrySet().stream()
                .filter(hasMatchingCount())
                .collect(Collectors.toList());
    }

    private Predicate<Map.Entry<LottoRank, Integer>> hasMatchingCount() {
        return entry -> entry.getKey().hasMatchingCount();
    }

    public long getTotalPrizeMoney() {
        return (long) LottoRank.FIRST.getPrizeMoney() * getCount(LottoRank.FIRST)
                + (long) LottoRank.SECOND.getPrizeMoney() * getCount(LottoRank.SECOND)
                + (long) LottoRank.THIRD.getPrizeMoney() * getCount(LottoRank.THIRD)
                + (long) LottoRank.FOURTH.getPrizeMoney() * getCount(LottoRank.FOURTH);
    }

    public double calculateRateOfReturn(final int paymentAmount) {
        return ((double) getTotalPrizeMoney()) / paymentAmount;
    }

    public static LottoResults calculateResults(final List<Lotto> lottos, final WinnerNumbers winnerNumbers) {
        LottoResults lottoResults = new LottoResults();

        for (Lotto lotto : lottos) {
            lottoResults.incrementRankCount(lotto.calculateLottoRank(winnerNumbers));
        }

        return lottoResults;
    }
}
