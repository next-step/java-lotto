package lotto_auto.model;

import lotto_auto.ErrorMessage;

public enum LottoResult {

    FIRST(true, 2000000000L, 1, 6),
    SECOND(true, 1500000L, 2, 5),
    THIRD(true, 50000L, 3, 4),
    FOURTH(true, 5000L, 4, 3),
    FIFTH(false, 0L, 5, 2),
    SIXTH(false, 0L, 6, 1),
    SEVENTH(false, 0L, 7, 0);

    private boolean winning;
    private long money;
    private int rank;
    private int matchNum;

    public boolean isWinning() {
        return winning;
    }

    public long getMoney() {
        return money;
    }

    public int getMatchNum() {
        return matchNum;
    }

    LottoResult(boolean winning, long money, int rank, int matchNum) {
        this.winning = winning;
        this.money = money;
        this.rank = rank;
        this.matchNum = matchNum;
    }

    public boolean isRank(int rank) {
        return this.rank == rank;
    }

    public static LottoResult valueOfMatchNum(int matchNum) {
        for (LottoResult value : LottoResult.values()) {
            if (value.matchNum == matchNum) {
                return value;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MATCH_NUM);
    }

    public static LottoResult valueOfRank(int rank) {
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.rank == rank) {
                return lottoResult;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MATCH_NUM);
    }
}
