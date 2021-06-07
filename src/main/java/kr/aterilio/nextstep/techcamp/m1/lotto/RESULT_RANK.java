package kr.aterilio.nextstep.techcamp.m1.lotto;

public enum RESULT_RANK {

    RANK_NONE(0, 0),
    RANK_MATCH_3(3, 5_000),
    RANK_MATCH_4(4, 50_000),
    RANK_MATCH_5(5, 1_500_000),
    RANK_MATCH_6(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;

    RESULT_RANK(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static RESULT_RANK valueOf(int matchCount) {
        RESULT_RANK result = RANK_NONE;
        for (RESULT_RANK rank : RESULT_RANK.values()) {
            result = rank.matchOrDefault(matchCount, result);
        }
        return result;
    }

    public RESULT_RANK matchOrDefault(int matchCount, RESULT_RANK result) {
        if (this.matchCount == matchCount) {
            return this;
        }
        return result;
    }

    public int prize() {
        return this.prizeMoney;
    }

    public String detail() {
        return String.format("%d개 일치(%d원)", matchCount, prizeMoney);
    }
}
