package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST("1등", 6, 2_000_000_000, false),
    SECOND("보너스", 5, 30_000_000, true),
    THIRD("2등", 5, 1_500_000, false),
    FOURTH("3등", 4, 50_000, false),
    FIFTH("4등", 3, 5_000, false),
    NONE("낙첨", 0, 0, false);

    private final String rank;
    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonus;

    LottoRank(String rank, int matchCount, int prizeMoney, boolean bonus) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRank valueOfMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static LottoRank find(int matchCount, boolean matchBonus) {
        if(matchCount == 5 && matchBonus) {
            return  Arrays.stream(values())
                    .filter(lottoRank -> lottoRank.getMatchCount() == matchCount && lottoRank.bonus)
                    .findFirst()
                    .orElse(NONE);
        }
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount && !lottoRank.bonus)
                .findFirst()
                .orElse(NONE);
    }
}
