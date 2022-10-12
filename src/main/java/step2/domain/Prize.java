package step2.domain;

import java.util.Arrays;
import java.util.Map;

public enum Prize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney){
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static int calculateTotalIncome(final Map<Integer, Integer> drawLottoResult){
        int totalIncome = 0;
        for (int matchCount : drawLottoResult.keySet()) {
            totalIncome += getPrizeMoney(matchCount);
        }
        return totalIncome;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static int getPrizeMoney(int matchCount) {
        if (matchCount > 6) {
            throw new IllegalArgumentException("6개 이상 당첨될 수 없습니다.");
        }

        return Arrays.stream(Prize.values())
            .filter(prize -> prize.getMatchCount() == matchCount)
            .findAny()
            .get()
            .prizeMoney;
    }
}
