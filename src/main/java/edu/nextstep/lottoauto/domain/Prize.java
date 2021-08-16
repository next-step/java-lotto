package edu.nextstep.lottoauto.domain;

public enum Prize {
    FIRST(6, 200_000_000),
    SECOND(5, 15_000_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NULL(0, 0);


    private final int countOfMatch;
    private final int winningPrize;

    Prize(int countOfMatch, int winningPrize) {
        this.countOfMatch = countOfMatch;
        this.winningPrize = winningPrize;
    }

    public static Prize of(int numOfMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.getCountOfMatch() == numOfMatch) {
                return prize;
            }
        }
        return NULL;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningPrize() {
        return winningPrize;
    }


}
