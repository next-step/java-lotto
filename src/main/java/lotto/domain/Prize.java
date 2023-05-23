package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {

    FIRST_PLACE("6개 일치 (2000000000원)", 6, 2000000000, false),
    SECOND_PLACE("5개 일치, 보너스 볼 일치(30000000원) ", 5, 1500000, true),
    THIRD_PLACE("5개 일치 (1500000원)", 5, 50000, false),
    FOURTH_PLACE("4개 일치 (50000원)", 4, 5000, false),
    FIFTH_PLACE("3개 일치 (5000원)", 3, 5000, false),
    OUT_OF_PLACE("", 0, 0, false);

    private final String displayPrompt;
    private final int matchingCount;
    private final int prizeMoney;
    private final boolean needBonusBallMatch;

    Prize(String displayPrompt, int matchingCount, int prizeMoney, boolean needBonusBallMatch) {
        this.displayPrompt = displayPrompt;
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
        this.needBonusBallMatch = needBonusBallMatch;
    }

    public static Prize valueOf(int matchingCount, boolean bonusBallMatch) {

        return Arrays.stream(Prize.values())
                .filter(prize -> filterSatisfyMatchingCount(prize, matchingCount))
                .filter(prize -> filterSatisfyBonusBallMatch(prize, bonusBallMatch))
                .findFirst()
                .orElse(OUT_OF_PLACE);
    }

    private static boolean filterSatisfyMatchingCount(Prize prize, int matchingCount) {
        return prize.matchingCount == matchingCount;
    }

    private static boolean filterSatisfyBonusBallMatch(Prize prize, boolean bonusBallMatch) {
        if (prize.needBonusBallMatch) {
            return bonusBallMatch;
        }

        return Boolean.TRUE;
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

}
