package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;

public enum ResultRank {

    RANK_NONE(0, 0),
    RANK_MATCH_3(3, 5_000),
    RANK_MATCH_4(4, 50_000),
    RANK_MATCH_5(5, 1_500_000),
    RANK_MATCH_6(6, 2_000_000_000);
    
    private final int matchCount;
    private final int prizeMoney;

    ResultRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static ResultRank valueOf(int matchCount) {
        ResultRank result = RANK_NONE;
        for (ResultRank rank : ResultRank.values()) {
            result = rank.matchOrDefault(matchCount, result);
        }
        return result;
    }

    public boolean isNone() {
        return this == ResultRank.RANK_NONE;
    }

    public ResultRank matchOrDefault(int matchCount, ResultRank result) {
        if (this.matchCount == matchCount) {
            return this;
        }
        return result;
    }

    public int prize() {
        return this.prizeMoney;
    }

    public String detail() {
        if (isNone()) {
            return StringUtil.EMPTY_STRING;
        }
        return String.format("%d개 일치(%d원)", matchCount, prizeMoney);
    }
}
