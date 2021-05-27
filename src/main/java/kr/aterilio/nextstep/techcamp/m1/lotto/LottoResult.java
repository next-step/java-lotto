package kr.aterilio.nextstep.techcamp.m1.lotto;

public class LottoResult {

    private static final int RESULT_MATCH_COUNT_1ST = 6;
    private static final int RESULT_MATCH_COUNT_2ND = 5;
    private static final int RESULT_MATCH_COUNT_3RD = 4;
    private static final int RESULT_MATCH_COUNT_4TH = 3;

    private static final int PRIZE_MONEY_1ST = 2_000_000_000;
    private static final int PRIZE_MONEY_2ND = 1_500_000;
    private static final int PRIZE_MONEY_3RD = 50_000;
    private static final int PRIZE_MONEY_4TH = 5_000;

    public static int prizeMoney(int matchCount) {
        if (matchCount == RESULT_MATCH_COUNT_1ST) {
            return PRIZE_MONEY_1ST;
        }

        if (matchCount == RESULT_MATCH_COUNT_2ND) {
            return PRIZE_MONEY_2ND;
        }

        if (matchCount == RESULT_MATCH_COUNT_3RD) {
            return PRIZE_MONEY_3RD;
        }

        if (matchCount == RESULT_MATCH_COUNT_4TH) {
            return PRIZE_MONEY_4TH;
        }
        return 0;
    }
}
