package step2.domain;

import java.util.Arrays;

/**
 * 당첨 관련된 상수 정의 Enum
 */
public enum LottoRanking {
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6),
    MISS(0, 0);

    // 당첨금
    private int prizeMoney;

    // 당첨 숫자 갯수
    private int matchCount;

    LottoRanking(final int prizeMoney, final int matchCount) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static final LottoRanking valueOf(final long matchCount, final boolean bonusMatch) {
        LottoRanking lottoRanking = Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.getMatchCount() == matchCount)
                .findFirst()
                .orElse(MISS);

        // 5개 + 보너스(1개) 당첨인 경우 : 2등
        if (lottoRanking == LottoRanking.THIRD && bonusMatch)
            lottoRanking = LottoRanking.SECOND;

        return lottoRanking;
    }
}