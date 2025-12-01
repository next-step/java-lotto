package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false),
    ;

    private final int matchCnt;
    private final int prizeMoney;
    private final boolean bonusMatched;

    LottoRank(int matchCnt, int prizeMoney, boolean bonusMatched) {
        this.matchCnt = matchCnt;
        this.prizeMoney = prizeMoney;
        this.bonusMatched = bonusMatched;
    }

    public static LottoRank getLottoRank(int matchCnt, boolean bonusMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCnt, bonusMatched))
                .findFirst()
                .orElse(MISS);
    }

    private boolean matches(int matchCnt, boolean bonusMatched) {
        if (this.matchCnt != matchCnt) {
            return false;
        }

        if (matchCnt == 5) {
            return this.bonusMatched == bonusMatched;
        }

        return true;
    }


    public int getMatchCnt() {
        return matchCnt;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage(int count) {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개",
                    matchCnt, prizeMoney, count);
        }
        return String.format("%d개 일치 (%d원) - %d개",
                matchCnt, prizeMoney, count);
    }


    public boolean isAddAble() {
        return this != LottoRank.MISS;
    }
}
