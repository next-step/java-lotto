package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    public static final int DEFAULT_COUNT = 0;

    private Map<RESULT_RANK, Integer> matchCounts;

    public LottoResult(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        judge(luckyNumbers, lottoBundles);
    }

    private void judge(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        Map<Integer, Integer> matchResult = lottoBundles.matchCounts(luckyNumbers);
        putResult(matchResult);
    }

    private void putResult(Map<Integer, Integer> matchResult) {
        matchCounts = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : matchResult.entrySet()) {
            RESULT_RANK rank = RESULT_RANK.valueOf(entry.getKey());
            matchCounts.put(rank, entry.getValue());
        }
    }

    public int prizeMoney() {
        int result = 0;
        for (Map.Entry<RESULT_RANK, Integer> entry : matchCounts.entrySet()) {
            result += entry.getKey().prize() * entry.getValue();
        }
        return result;
    }

    public int is(RESULT_RANK rankMatch) {
        return matchCounts.getOrDefault(rankMatch, DEFAULT_COUNT);
    }
}
