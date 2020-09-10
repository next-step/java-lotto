package step3.domain;

import step3.utils.Constant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningType {
    FIRST(Constant.COUNT_SIX, Constant.LOTTO_PRIZE_FIRST),
    SECOND(Constant.COUNT_FIVE, Constant.LOTTO_PRIZE_SECOND),
    THIRD(Constant.COUNT_FIVE, Constant.LOTTO_PRIZE_THIRD),
    FOURTH(Constant.COUNT_FOUR, Constant.LOTTO_PRIZE_FOURTH),
    FIFTH(Constant.COUNT_THREE, Constant.LOTTO_PRIZE_FIFTH);

    private int sameCount;
    private int prize;

    public static WinningType getTicketLevel(int sameCount, boolean hasBonusNumber){
        if(sameCount < Constant.COUNT_THREE){
            return null;
        }

        if(sameCount == Constant.COUNT_FIVE){
            return findSecondWinningType(hasBonusNumber);
        }

        WinningType winningType;
        for(WinningType level : WinningType.values()){
            if(sameCount == level.getSameCount()){
                return level;
            }
        }

        return null;
    }

    WinningType(int sameCount, int prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getSameCount() {
        return sameCount;
    }

    private static WinningType findSecondWinningType(boolean hasBonusNumber){
        if(hasBonusNumber){
            return WinningType.SECOND;
        }

        return WinningType.THIRD;
    }

}
