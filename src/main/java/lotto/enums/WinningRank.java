package lotto.enums;

import lotto.domain.MatchedCount;
import lotto.domain.Prize;

import java.util.Arrays;

public enum WinningRank {
    FIRST_PLACE(new MatchedCount(6), new Prize(2_000_000_000)),
    SECOND_PLACE(new MatchedCount(5), new Prize(30_000_000)),
    THIRD_PLACE(new MatchedCount(5), new Prize(1_500_000)),
    FOURTH_PLACE(new MatchedCount(4), new Prize(50_000)),
    FIFTH_PLACE(new MatchedCount(3), new Prize(5_000)),
    ETC(new MatchedCount(), new Prize(0));

    private final MatchedCount matchedCount;
    private final Prize prize;

    WinningRank(MatchedCount matchedCount, Prize prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static WinningRank findByMacthedCount(MatchedCount matchedCount, boolean matchBonus) {

        if (FIFTH_PLACE.hasGreaterThan(matchedCount)) {
            return ETC;
        }

        WinningRank rank = findByMacthedCount(matchedCount);

        if (rank.isSecondPlace(matchBonus)) {
            return SECOND_PLACE;
        }

        if (rank.isSecondPlace(!matchBonus)) {
            return THIRD_PLACE;
        }

        return rank;
    }

    protected boolean hasGreaterThan(MatchedCount matchedCount) {
        return this.matchedCount.isGreaterThan(matchedCount);
    }

    protected boolean isSecondPlace(boolean matchBonus) {
        return matchBonus & this.hasBonus();
    }

    public static WinningRank findByMacthedCount(int matchedCount, boolean matchBonus) {
        return findByMacthedCount(new MatchedCount(matchedCount), matchBonus);
    }

    private static WinningRank findByMacthedCount(MatchedCount matchedCount) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchedCount.equals(matchedCount))
                .findAny()
                .orElse(ETC);
    }

    public Prize prize() {
        return prize;
    }

    public int multiply(Integer count) {
        return this.prize.multiply(count);
    }

    public MatchedCount matchedCount() {
        return matchedCount;
    }

    public boolean hasBonus() {
        return this.equals(SECOND_PLACE);
    }
}
