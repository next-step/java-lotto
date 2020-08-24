package lotto.domain;

import java.util.*;

import static java.util.stream.Collectors.toList;

public enum Ranking {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    MISS(0, 0, "일치 번호 없음");

    private final int matchesCount;
    private final int prizeMoney;
    private final String message;

    Ranking(int matchesCount, int prizeMoney, String message) {
        this.matchesCount = matchesCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public static Ranking valueOfRanking(int matchesCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchesCount == matchesCount)
                .filter(ranking -> !ranking.equals(SECOND) || hasBonusNumber)
                .findFirst()
                .orElse(MISS);
    }

    public static List<Ranking> findStatistics() {
        return Arrays.stream(values())
                .filter(ranking -> !Ranking.MISS.equals(ranking))
                .sorted(Collections.reverseOrder())
                .collect(toList());
    }
}
