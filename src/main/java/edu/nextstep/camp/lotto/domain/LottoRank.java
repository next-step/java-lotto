package edu.nextstep.camp.lotto.domain;

import java.util.*;

public enum LottoRank {

    FIRST(6, 2000000000), SECOND(5, 1500000), THIRD(4, 50000), FOURTH(3, 5000), NONE(0, 0);

    private static Map<Integer, LottoRank> lottoRankMap;

    private final int matchNumberCount;
    private final int winnings;

    LottoRank(int matchNumberCount, int winnings) {
        this.matchNumberCount = matchNumberCount;
        this.winnings = winnings;
    }

    public int getWinnings(){
        return this.winnings;
    }

    public static LottoRank withMatchNumberCount(int matchNumberCount) {
        if (lottoRankMap == null) {
            initLottoMap();
        }

        if (isWin(matchNumberCount)) return NONE;

        return lottoRankMap.get(matchNumberCount);
    }

    private static boolean isWin(int matchNumberCount) {
        return matchNumberCount < FOURTH.matchNumberCount || matchNumberCount > FIRST.matchNumberCount;
    }

    private static void initLottoMap() {
        lottoRankMap = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            lottoRankMap.put(lottoRank.matchNumberCount, lottoRank);
        }
    }
}
