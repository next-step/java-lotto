package lotto.statistics;

import java.util.Arrays;

public enum Earn {
    THREE_MATCHED(Ranking.FIFTH, 3, 5_000),
    FOUR_MATCHED(Ranking.FOURTH, 4, 50_000),
    FIVE_MATCHED(Ranking.THIRD, 5, 1_500_000),
    BONUS_MATCHED(Ranking.SECOND, 5, 3_000_000),
    SIX_MATCHED(Ranking.FIRST, 6, 2_000_000_000);

    private Ranking ranking;
    private int matchCount;
    private int earn;

    Earn(Ranking ranking, int matchCount, int earn) {
        this.ranking = ranking;
        this.matchCount = matchCount;
        this.earn = earn;
    }

    public static Earn match(Ranking ranking) {
        return Arrays.stream(values())
            .filter(value -> value.ranking == ranking)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("정의되지 않은 ranking 입니다"));
    }

    public static Earn match(int matchCount) {
        return Arrays.stream(values())
            .filter(value -> value.matchCount == matchCount)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("match count는 3, 4, 5, 6만 사용이 가능합니다"));
    }

    public int winningPrice() {
        return earn;
    }

    public String message(int repeatedCount) {
        return new StringBuffer()
            .append(matchCount)
            .append(suffix())
            .append(earn)
            .append("원)- ")
            .append(repeatedCount)
            .append("개\n")
            .toString();
    }

    private String suffix() {
        if (ranking == Ranking.SECOND) {
            return "개 일치, 보너스볼 일치(";
        }
        return "개 일치 (";
    }

}
