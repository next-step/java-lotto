package lotto.domain;

import java.util.EnumMap;

public final class Result {

    private static final int INIT = 0;
    private static final int ADD = 1;
    private static final int LOTTO_PRICE = 1000;

    private final EnumMap<Rank, Integer> rankEnumMap = new EnumMap<>(Rank.class);

    public Result() {
        for (Rank rank : Rank.values()) {
            rankEnumMap.put(rank, INIT);
        }
    }

    public void addHitsCount(final Rank rank) {
        rankEnumMap.put(rank, rankEnumMap.getOrDefault(rank, INIT) + ADD);
    }

    public int getRankHitsCount(final Rank rank) {
        return rankEnumMap.get(rank);
    }

    public double calculateTotalWinningMoney() {
        int totalPrize = INIT;
        int lottoCount = INIT;

        for (Rank rank : rankEnumMap.keySet()) {
            totalPrize += rank.totalWinningMoney(rankEnumMap.get(rank));
            lottoCount += rankEnumMap.get(rank);
        }

        return (double) totalPrize / (lottoCount * LOTTO_PRICE);
    }

}
