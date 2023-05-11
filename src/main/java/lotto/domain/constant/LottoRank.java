package lotto.domain.constant;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6,false, 2_000_000_000),
    SECOND(5,true, 30_000_000),
    THIRD(5,false, 1_500_000),
    FOURTH(4,false, 50_000),
    FIFTH(3,false, 5_000),
    MISS(0,false, 0);

    private final int hitNumber;
    private final boolean matchBonus;
    private final int winningAmount;

    LottoRank(Integer hitNumber, boolean matchBonus, Integer winningAmount) {
        this.hitNumber = hitNumber;
        this.matchBonus = matchBonus;
        this.winningAmount = winningAmount;
    }

    public static LottoRank valueOf(int hitNumber, boolean matchBonus) {
        return Arrays.stream(values())
            .filter(
                lottoRank -> lottoRank.hitNumber == hitNumber && lottoRank.matchBonus == matchBonus)
            .findAny()
            .orElse(MISS);
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getHitNumber() {
        return hitNumber;
    }

}
