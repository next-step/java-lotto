package step2.domain;

import step2.Constant;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningType {
    FIRST(Constant.LOTTO_PRIZE_FIRST, Constant.COUNT_SIX),
    SECOND(Constant.LOTTO_PRIZE_SECOND, Constant.COUNT_FIVE),
    THIRD(Constant.LOTTO_PRIZE_THIRD, Constant.COUNT_FIVE),
    FOURTH(Constant.LOTTO_PRIZE_FOURTH, Constant.COUNT_FOUR),
    FIFTH(Constant.LOTTO_PRIZE_FIFTH, Constant.COUNT_THREE);

    private static final Map<Integer, WinningType> winningTypeMap = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(WinningType::getPrize, winningType -> winningType)));
    private int prize;
    private int sameCount;

    public int getPrize() {
        return prize;
    }

    public int getSameCount() {
        return sameCount;
    }

    WinningType(int prize, int sameCount) {
        this.prize = prize;
        this.sameCount = sameCount;
    }

    public static int findSameCount(int prize) {
        WinningType winningType = winningTypeMap.get(prize);

        return winningType.getSameCount();
    }

}
