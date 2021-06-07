package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.Map;
import java.util.TreeMap;

public class LottoResult {

    private static final int DEFAULT_COUNT = 0;
    private static final int INIT_COUNT = 0;

    private int prizeMoney = 0;
    private float rateOfReturn = 0.f;

    // 정렬 출력을 위해 TreeMap 으로 변경
    private final Map<RESULT_RANK, Integer> matchCounts = new TreeMap<>();

    public LottoResult(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        judge(luckyNumbers, lottoBundles);
    }

    private void judge(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        Map<Integer, Integer> matchResult = lottoBundles.matchCounts(luckyNumbers);
        collects(matchResult);
        calculatePrizeMoney();
        calculateRateOfReturn(lottoBundles.paid());
    }

    private void collects(Map<Integer, Integer> matchResult) {
        clear();
        for(Map.Entry<Integer, Integer> entry : matchResult.entrySet()) {
            RESULT_RANK rank = RESULT_RANK.valueOf(entry.getKey());
            collectByRank(rank, entry.getValue());
        }
    }

    private void clear() {
        matchCounts.clear();
        for(RESULT_RANK rank : RESULT_RANK.values()) {
            collectByRank(rank, INIT_COUNT);
        }
    }

    private void collectByRank(RESULT_RANK rank, Integer count) {
        if (rank == RESULT_RANK.RANK_NONE) {
            return;
        }
        matchCounts.put(rank, count);
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

    public String detail() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<RESULT_RANK, Integer> entry : matchCounts.entrySet()) {
            sb.append(String.format("%s - %d개\n", entry.getKey().detail(), entry.getValue()));
        }
        return sb.toString();
    }

    public float rateOfReturn() {
        return rateOfReturn;
    }
}
