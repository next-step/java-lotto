package kr.aterilio.nextstep.techcamp.m1.lotto;

public class LottoResult {

    public static int prizeMoney(int matchCount) {
        return RESULT_RANK.valueOf(matchCount).prize();
    }
}
