package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int DEFAULT_COUNT = 0;

    private int prizeMoney = 0;
    private float rateOfReturn = 0.f;
    private Map<RESULT_RANK, Integer> matchCounts;

    public LottoResult(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        judge(luckyNumbers, lottoBundles);
    }

    private void judge(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        Map<Integer, Integer> matchResult = lottoBundles.matchCounts(luckyNumbers);
        collect(matchResult);
        calculatePrizeMoney();
        calculateRateOfReturn(lottoBundles.paid());
    }

    private void collect(Map<Integer, Integer> matchResult) {
        matchCounts = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : matchResult.entrySet()) {
            RESULT_RANK rank = RESULT_RANK.valueOf(entry.getKey());
            matchCounts.put(rank, entry.getValue());
        }
    }

    public void calculatePrizeMoney() {
        prizeMoney = 0;
        for (Map.Entry<RESULT_RANK, Integer> entry : matchCounts.entrySet()) {
            prizeMoney += entry.getKey().prize() * entry.getValue();
        }
    }

    private void calculateRateOfReturn(int paid) {
        rateOfReturn = (float) prizeMoney / paid;
    }

    public int is(RESULT_RANK rankMatch) {
        return matchCounts.getOrDefault(rankMatch, DEFAULT_COUNT);
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public float rateOfReturn() {
        return rateOfReturn;
    }
}
