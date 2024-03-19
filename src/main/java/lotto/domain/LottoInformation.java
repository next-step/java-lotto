package lotto.domain;

import java.util.*;

public enum LottoInformation {

    NOT_MATCH(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000)
    ;

    public static final int NUMBER_INDEX_FROM = 0;
    public static final int NUMBER_INDEX_TO = 6;

    private final int matchCount;
    private final int winAmount;

    LottoInformation(int matchCount, int winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }

    private static final Map<Integer, LottoInformation> matchAmountMap = new HashMap<>();
    static {
        for (LottoInformation information : LottoInformation.values()) {
            matchAmountMap.put(information.matchCount, information);
        }
    }

    public static List<LottoInformation> getLottoInformations() {
        return List.of(LottoInformation.values());
    }

    public static int getWinAmount(LottoInformation information) {
        return matchAmountMap.get(information.matchCount).winAmount;
    }

    public static LottoInformation lookup(int matchCount) {
        if (anyMatch(matchCount)) {
            return matchAmountMap.get(matchCount);
        }
        return NOT_MATCH;
    }

    public static boolean anyMatch(Integer matchCount) {
        LottoInformation information = matchAmountMap.get(matchCount);
        return information != null && information != NOT_MATCH;
    }

    public static int getMatchCount(LottoInformation information) {
        return information.matchCount;
    }

}
