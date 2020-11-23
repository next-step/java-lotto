package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DrawResult {

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

    DrawResult(boolean winning, long money, int rank, int matchNum) {
        this.winning = winning;
        this.money = money;
        this.rank = rank;
        this.matchNum = matchNum;
    }

    public boolean isRank(int rank) {
        return this.rank == rank;
    }

    public boolean isMatchNum(int matchNum) {
        return this.matchNum == matchNum;
    }

    public static DrawResult valueOfMatchNum(int matchNum) {
        List<DrawResult> drawResults =
                Arrays.stream(DrawResult.values())
                        .filter(item -> item.isMatchNum(matchNum))
                        .collect(Collectors.toList());
        if (drawResults.size() == 1) {
            return drawResults.get(0);
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MATCH_NUM);
    }

    public static DrawResult valueOfRank(int rank) {
        List<DrawResult> drawResults =
                Arrays.stream(DrawResult.values())
                        .filter(item -> item.isRank(rank))
                        .collect(Collectors.toList());
        if (drawResults.size() == 1) {
            return drawResults.get(0);
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANK);
    }
}
