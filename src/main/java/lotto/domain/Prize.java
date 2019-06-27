package lotto.domain;

import java.util.Arrays;

public enum Prize {
    NOT_MATCH(0, 0, false),
    THREE_NUMBER_MATCH(3, 5_000, false),
    FOUR_NUMBER_MATCH(4, 50_000, false),
    FIVE_NUMBER_MATCH(5, 1_500_000, false),
    FIVE_BONUS_NUMBER_MATCH(5, 30_000_000, true),
    SIX_NUMBER_MATCH(6, 2_000_000_000, false);
    
    private int matchCount;
    private long prizeMoney;
    private boolean isMatchedBonas;
    
    Prize(int matchCount, long prizeMoney, boolean isMatchedBonas) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isMatchedBonas = isMatchedBonas;
    }
    
    public static Prize getPrize(final int matchCount, final boolean isMatchedBonas) {
        if (matchCount == FIVE_BONUS_NUMBER_MATCH.matchCount && isMatchedBonas) {
            return FIVE_BONUS_NUMBER_MATCH;
        }
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.matchCount == matchCount)
            .findFirst()
            .orElse(Prize.NOT_MATCH);
    }
    
    public long getPrizeMoney() {
        return prizeMoney;
    }
    
    public String getInfo() {
        String bonusBallMent = isMatchedBonas ? ", 보너스 볼 일치" : "";
        return matchCount + "개 일치" + bonusBallMent + " (" + prizeMoney + "원)- ";
    }
}
