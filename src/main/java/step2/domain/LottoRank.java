package step2.domain;

import java.util.Arrays;

public enum LottoRank {
    ETC(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private static final int BONUS_COUNT_THRESHOLD = 5;

    private final long hitCount;
    private final int prizeMoney;

    LottoRank(long hitCount, int prizeMoney) {
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank toRank(long hitCount, boolean isContainBonusNumber) {
        validateHitCountRange(hitCount);
        if (hitCount != BONUS_COUNT_THRESHOLD) {
            return withoutBonusNumber(hitCount);
        }
        return withBonusNumber(isContainBonusNumber);
    }

    private static void validateHitCountRange(long hitCount) {
        if (hitCount < 0 || hitCount > 6) {
            throw new IllegalArgumentException("hitCount 범위는 1과 6사이여야 합니다.");
        }
    }

    private static LottoRank withoutBonusNumber(Long hitCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.hitCount != BONUS_COUNT_THRESHOLD)
                .filter(ranking -> ranking.hitCount == hitCount)
                .findFirst()
                .orElse(ETC);
    }

    private static LottoRank withBonusNumber(boolean isContainBonusNumber) {
        if (isContainBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return hitCount + "개 일치 + 보너스번호일치 (" + prizeMoney + "원)";
        }
        return hitCount + "개 일치 (" + prizeMoney + "원)";
    }
}
