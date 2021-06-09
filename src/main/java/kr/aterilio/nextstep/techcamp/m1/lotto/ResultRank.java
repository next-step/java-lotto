package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;

public enum ResultRank {

    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);
    
    private final int matchCount;
    private final int prizeMoney;
    private final boolean matchBonus;

    ResultRank(int matchCount, int prizeMoney) {
        this(matchCount, prizeMoney, false);
    }

    ResultRank(int matchCount, int prizeMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public static ResultRank valueOf(int matchCount, boolean matchBonus) {
        ResultRank result = NONE;
        for (ResultRank rank : ResultRank.values()) {
            result = rank.matchOrDefault(matchCount, matchBonus, result);
        }
        return result;
    }

    private ResultRank matchOrDefault(int matchCount, boolean matchBonus, ResultRank result) {
        if (this.matchCount != matchCount) {
            return result;
        }
        if (this.matchCount == SECOND.matchCount && this.matchBonus != matchBonus) {
            return result;
        }
        return this;
    }

    public int prize() {
        return this.prizeMoney;
    }

    public String detail() {
        if (isNone()) {
            return StringUtil.EMPTY_STRING;
        }
        return String.format("%d개 일치%s(%d원)", matchCount, bonusDesc(), prizeMoney);
    }

    private String bonusDesc() {
        if (matchBonus) {
            return ", 보너스 볼 일치";
        }
        return StringUtil.EMPTY_STRING;
    }

    public boolean isNone() {
        return this == ResultRank.NONE;
    }
}
