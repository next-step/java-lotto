package lotto.domain.enums;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    ETC(-1, 0);

    private static final int MIN_MATCH_COUNT = 0;

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMath) {
        validate(matchCount);
        if (isSecondOrThird(matchCount)) {
            return bonusMath ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(ETC);
    }

    private static boolean isSecondOrThird(int matchCount) {
        return matchCount == SECOND.matchCount;
    }

    private static void validate(int matchCount) {
        if (matchCount < MIN_MATCH_COUNT) {
            throw new IllegalArgumentException("일치 개수는 음수일 수 없습니다.");
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

}
