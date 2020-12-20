package lotto.domain;

import java.util.Arrays;

public enum WinningLottoType {
    MATCH_ZERO("0", 0, 0),
    MATCH_THREE("3", 3, 5000),
    MATCH_FOUR("4", 4, 50000),
    MATCH_FIVE("5", 5, 1500000),
    MATCH_SIX("6", 6, 2000000000);
    int matchCount;
    long winnerMoney;

    public long getWinnerMoney() {
        return winnerMoney;
    }

    public String getName() {
        return name;
    }

    String name;

    WinningLottoType( String name, int matchCount, long winnerMoney){
        this.name = name;
        this.matchCount = matchCount;
        this.winnerMoney = winnerMoney;
    }
}
