package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.Arrays;

public enum DrawResult {

    FIRST(false, 2000000000L, 1, 6),
    SECOND(true, 30000000L, 2, 5),
    THIRD(false, 1500000L, 3, 5),
    FOURTH(false, 50000L, 4, 4),
    FIFTH(false, 5000L, 5, 3),
    SIXTH(false, 0L, 6, 2),
    SEVENTH(false, 0L, 7, 1),
    EIGHTH(false, 0L, 8, 0);

    private boolean bonus;
    private long money;
    private int rank;
    private int matchNum;

    public boolean isBonus() {
        return bonus;
    }

    public long getMoney() {
        return money;
    }

    public int getMatchNum() {
        return matchNum;
    }

    DrawResult(boolean bonus, long money, int rank, int matchNum) {
        this.bonus = bonus;
        this.money = money;
        this.rank = rank;
        this.matchNum = matchNum;
    }

    public static DrawResult valueOf(boolean isBonus, int matchNum) {
        switch (matchNum) {
            case 6:
                return FIRST;
            case 5:
                return getBonusResult(isBonus);
            case 4:
                return FOURTH;
            case 3:
                return FIFTH;
            case 2:
                return SIXTH;
            case 1:
                return SEVENTH;
            case 0:
                return EIGHTH;
            default:
                throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_RESULT);
        }
    }

    private static DrawResult getBonusResult(boolean isBonus){
        if(isBonus){
            return SECOND;
        }
        return THIRD;
    }

    public static DrawResult valueOfRank(int rank) {
        return Arrays
                .stream(DrawResult.values())
                .filter(item -> item.rank == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MATCH_NUM));
    }
}
