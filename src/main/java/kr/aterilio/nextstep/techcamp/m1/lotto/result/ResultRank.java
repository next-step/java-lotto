package kr.aterilio.nextstep.techcamp.m1.lotto.result;

import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;

public enum ResultRank {

    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private static final String MSG_ERR_OUT_OF_RANGE = "로또 결과의 판정이 범위를 벗어났습니다.";
    private static final String FORMAT_DETAIL = "%d개 일치%s(%d원)";

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
        validateRange(matchCount);
        if (SECOND.matchCount == matchCount) {
            return valueOf2ndOr3rd(matchBonus);
        }
        return findRank(matchCount);
    }

    private static void validateRange(int matchCount) {
        if (matchCount < NONE.matchCount || matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException(MSG_ERR_OUT_OF_RANGE);
        }
    }

    private static ResultRank valueOf2ndOr3rd(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    private static ResultRank findRank(int matchCount) {
        ResultRank result = NONE;
        ResultRank[] resultRanks = ResultRank.values();
        for (ResultRank rank : resultRanks) {
            result = rank.matchOrDefault(matchCount, result);
        }
        return result;
    }

    private ResultRank matchOrDefault(int matchCount, ResultRank result) {
        if (this.matchCount != matchCount) {
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
        return String.format(FORMAT_DETAIL, matchCount, bonusDesc(), prizeMoney);
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
