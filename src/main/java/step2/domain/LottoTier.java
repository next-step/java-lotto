package step2.domain;

import java.util.Arrays;

public enum LottoTier {

    FIRST(6, false, 2_000_000_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 6; }
    },
    SECOND(5, true, 30_000_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 5 && isMatchBonusNumber == true; }
    },
    THIRD(5, false,150_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 5 && isMatchBonusNumber == false; }
    },
    FOURTH(4, false, 50_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 4; }
    },
    FIFTH(3, false,5_000) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount == 3; }
    },
    NONE(0, false,0) {
        public boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber) {return matchedNumberCount < 3; }
    };

    private long matchedNumberCount;
    private boolean isMatchBonusNumber;
    private int prize;

    LottoTier(long matchedNumberCount, boolean isMatchBonusNumber, int prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.prize = prize;
    }

    public int calculatePrize(int count) {
        return count * prize;
    }

    public static LottoTier getTier(long matchedNumberCount, boolean isMatchBonusNumber) {
        return Arrays.stream(values())
                .filter(tier -> tier.isWinning(matchedNumberCount, isMatchBonusNumber) == true)
                .findFirst()
                .orElse(NONE);
    }

    abstract boolean isWinning(long matchedNumberCount, boolean isMatchBonusNumber);
}
