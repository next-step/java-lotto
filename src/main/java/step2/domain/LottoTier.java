package step2.domain;

import java.util.Arrays;

public enum LottoTier {

    FIRST(6, 2_000_000_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 6; }
    },
    SECOND(5, 30_000_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 5 && isMatchBonusNumber == true; }
    },
    THIRD(5, 150_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 5 && isMatchBonusNumber == false; }
    },
    FOURTH(4, 50_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 4; }
    },
    FIFTH(3,5_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 3; }
    },
    NONE(0,0) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount < 3; }
    };

    private long matchedNumberCount;
    private int prize;

    LottoTier(long matchedNumberCount, int prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.prize = prize;
    }

    abstract boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber);

    public int calculatePrize(int count) {
        return count * prize;
    }

    public static LottoTier getTier(long matchedNumberCount, boolean isMatchBonusNumber) {
        return Arrays.stream(values())
                .filter(tier -> tier.isWinning(matchedNumberCount, isMatchBonusNumber) == true)
                .findFirst()
                .orElse(NONE);
    }
}
