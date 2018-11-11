package lotto.model;

import java.util.Arrays;

public enum PrizeMoneyType {
    MATCH_3(3, 5000)
    , MATCH_4(4, 50000)
    , MATCH_5(5, 1500000)
    , MATCH_6(6, 2000000000)
    ;
    private Integer matchNum;
    private Integer prizeMoney;
    PrizeMoneyType(Integer matchNum, Integer prizeMoney) {
        this.matchNum = matchNum;
        this.prizeMoney = prizeMoney;
    }

    public Integer getMatchNum() {
        return matchNum;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}
