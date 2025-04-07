package lotto;

import java.util.Map;

public enum LottoRank {
    First(6, false, 2000000000),
    Second(5, true, 2000000000),
    Third(5, false, 1500000),
    Fourth(4, false, 50000),
    Fifth(3, false, 5000);

    private final int matchCount;
    private final boolean containsBonusNumber;
    private final int prizeMoney;

    LottoRank(int matchCount, boolean containsBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.containsBonusNumber = containsBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getPrize(int matchCount) {
        return LottoRank.getPrize(matchCount, false);
    }

    public static LottoRank getPrize(int matchCount, boolean containsBonusNumber) {
        for (LottoRank prize : values()) {
            if (prize.matchCount == matchCount && prize.containsBonusNumber == containsBonusNumber) {
                return prize;
            }
        }
        throw new IllegalArgumentException("Invalid match count: " + matchCount);
    }

    public static int calculateTotalWinningAmount(Map<Integer, Integer> matchCounts) {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : matchCounts.entrySet()) {
            int matches = entry.getKey();
            int count = entry.getValue();
            LottoRank prize = getPrize(matches, false);
            totalAmount += prize.calculateWinningAmount(count);
        }
        return totalAmount;
    }

    public int calculateWinningAmount(int count) {
        return prizeMoney * count;
    }

    @Override
    public String toString() {
        return matchCount + "개 일치 (" + prizeMoney + "원)";
    }
}
