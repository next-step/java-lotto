package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000L, 6, false) {
        @Override
        public boolean checkLottoMatch(long matchCount, boolean bonusCount) {
            return matchCount == this.matchCount;
        }
    },
    SECOND(30_000_000L, 5, true) {
        @Override
        public boolean checkLottoMatch(long matchCount, boolean bonusCount) {
            return matchCount == this.matchCount && bonusCount;
        }
    },
    THIRD(1_500_000L, 5, false) {
        @Override
        public boolean checkLottoMatch(long matchCount, boolean bonusCount) {
            return matchCount == this.matchCount && !bonusCount;
        }
    },
    FOURTH(50_000L, 4, false) {
        @Override
        public boolean checkLottoMatch(long matchCount, boolean bonusCount) {
            return matchCount == this.matchCount;
        }
    },
    FIFTH(5_000L, 3, false) {
        @Override
        public boolean checkLottoMatch(long matchCount, boolean bonusCount) {
            return matchCount == this.matchCount;
        }
    },
    NONE(0L, 2, false) {
        @Override
        public boolean checkLottoMatch(long matchCount, boolean bonusCount) {
            return matchCount <= this.matchCount;
        }
    };

    protected final long matchCount;
    protected final boolean bonusCount;
    private final long price;

    LottoRank(long price, long matchCount, boolean bonusCount) {
        this.price = price;
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
    }

    public static LottoRank findLottoRank(long matchCount, boolean bonusCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.checkLottoMatch(matchCount, bonusCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("로또 당첨 정보가 부정확합니다."));
    }

    public long sumPrize(long count) {
        return this.price * count;
    }

    public abstract boolean checkLottoMatch(long matchCount, boolean bonusCount);
}
