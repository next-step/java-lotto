package nextstep.lotto.dto;

import java.util.Arrays;

public enum LottoRank {
    SIX(6,2000000000),
    FIVE(5,1500000),
    FOUR(4,50000),
    THREE(3,5000),
    ETC(0,0);

    private final int matchCount;
    private final int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward(){
        return reward;
    }
    public static LottoRank of(int matchCount) {
        return Arrays.stream(values())
                .filter(ticket -> ticket.matchCount == matchCount)
                .findFirst()
                .orElse(ETC);
    }
}
