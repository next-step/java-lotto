package lotto.domain;

import java.util.Arrays;

public enum WinningLottoType {
    MATCH_ZERO("꽝", 0, 0),
    MATCH_THREE("3개 일치", 3, 5000),
    MATCH_FOUR("4개 일치", 4, 50000),
    MATCH_FIVE("5개 일치", 5, 1500000),
    MATCH_SIX("6개 일치", 6, 2000000000);
    int matchCount;
    long winnerMoney;
    String name;

    public long getWinnerMoney() {
        return winnerMoney;
    }

    public String getName() {
        return name;
    }

    WinningLottoType( String name, int matchCount, long winnerMoney){
        this.name = name;
        this.matchCount = matchCount;
        this.winnerMoney = winnerMoney;
    }
}
