package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {

    FIRST_PLACE("6개 일치 (2000000000원)", 6, 2000000000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치(30000000원) ", 5, 1500000),
    THIRD_PLACE("5개 일치 (1500000원)", 5, 50000),
    FOURTH_PLACE("4개 일치 (50000원)", 4, 5000),
    FIFTH_PLACE("3개 일치 (5000원)", 3, 5000),
    OUT_OF_PLACE("", 0, 0);

    private final String displayPrompt;
    private final int matchingCount;
    private final int prizeMoney;

    Prize(String displayPrompt, int matchingCount, int prizeMoney) {
        this.displayPrompt = displayPrompt;
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int matchingCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchingCount == matchingCount)
                .filter(prize -> prize != Prize.SECOND_PLACE)
                .findFirst()
                .orElse(OUT_OF_PLACE);
    }

    public static List<Prize> extractDisplayPrize() {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.OUT_OF_PLACE)
                .collect(Collectors.toList());
    }

    public long calculatePriceMoney(long count) {
        return this.prizeMoney * count;
    }

    public String getDisplayPrompt() {
        return displayPrompt;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
