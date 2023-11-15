package step3.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int winningMoney;

    LottoRank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int matchCount() {
        return matchCount;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public boolean isSecond(){
        return this == SECOND;
    }

    public boolean isNotMiss(){
        return this != MISS;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findFirst().orElse(MISS);
    }
}
