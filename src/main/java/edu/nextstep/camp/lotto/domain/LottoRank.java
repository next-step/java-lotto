package edu.nextstep.camp.lotto.domain;

import java.util.*;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

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

    public static LottoRank valueOf(int matchNumberCount, boolean isMatchBonus) {
        if (lottoRankMap == null) {
            initLottoMap();
        }

        if (isWin(matchNumberCount)) return NONE;

        if (matchNumberCount == SECOND.matchNumberCount && isMatchBonus){
            return SECOND;
        }

        return lottoRankMap.get(matchNumberCount);
    }

    /**
     * @Deprecated 2등 보너스 번호 추가로 사용 안함.
     */
    @Deprecated
    public static LottoRank valueOf(int matchNumberCount) {
        if (lottoRankMap == null) {
            initLottoMap();
        }

        if (isWin(matchNumberCount)) return NONE;

        return lottoRankMap.get(matchNumberCount);
    }

    private static boolean isWin(int matchNumberCount) {
        return matchNumberCount < FIFTH.matchNumberCount || matchNumberCount > FIRST.matchNumberCount;
    }

    private static void initLottoMap() {
        lottoRankMap = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            putLottoRank(lottoRank);
        }
    }

    private static void putLottoRank(LottoRank lottoRank) {
        if (!lottoRank.equals(SECOND)){
            lottoRankMap.put(lottoRank.matchNumberCount, lottoRank);
        }
    }
}
