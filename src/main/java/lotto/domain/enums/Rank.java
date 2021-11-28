package lotto.domain.enums;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {

    FIRST(6, 2000000000, (matchCount, bonusMatch) -> matchCount == 6),
    SECOND(5, 30000000, (matchCount, bonusMatch) -> matchCount == 5 && bonusMatch),
    THIRD(5, 1500000, (matchCount, bonusMatch) -> matchCount == 5 && !bonusMatch),
    FOURTH(4, 50000, (matchCount, bonusMatch) -> matchCount == 4),
    FIFTH(3, 5000, (matchCount, bonusMatch) -> matchCount == 3),
    ETC(-1, 0, (matchCount, bonusMatch) -> matchCount == 2);

    private static final int MAX_MATCH_COUNT = 6;
    private static final int MIN_MATCH_COUNT = 0;

    private final int matchCount;
    private final int prize;
    private final BiFunction<Integer, Boolean, Boolean> condition;

    Rank(int matchCount, int prize, BiFunction<Integer, Boolean, Boolean> condition) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.condition = condition;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        validate(matchCount);

        return Arrays.stream(values())
                .filter(rank -> rank.condition.apply(matchCount, bonusMatch))
                .findAny()
                .orElse(ETC);
    }

    private static void validate(int matchCount) {
        if (matchCount > MAX_MATCH_COUNT) {
            throw new IllegalArgumentException("일치 개수는 6개 초과일 수 없습니다.");
        }
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
