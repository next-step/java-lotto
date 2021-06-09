package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.Map;
import java.util.TreeMap;

public class LottoResult {

    private static final int EMPTY_COUNT = 0;
    private static final int EMPTY_PAID = 0;
    private static final float NONE_RETURN_RATE = 0.f;

    private final int prizeMoney;
    private final float rateOfReturn;

    private final Map<ResultRank, Integer> matchCounts;

    public LottoResult(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        matchCounts = judge(luckyNumbers, lottoBundles);
        prizeMoney = calculatePrizeMoney(matchCounts);
        rateOfReturn = calculateRateOfReturn(prizeMoney, lottoBundles.paid());
    }

    private Map<ResultRank, Integer> judge(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        return collects(
                lottoBundles.matchCounts(luckyNumbers)
        );
    }

    private Map<ResultRank, Integer> collects(Map<ResultRank, Integer> matchResult) {
        Map<ResultRank, Integer> collection = init();
        for (Map.Entry<ResultRank, Integer> entry : matchResult.entrySet()) {
            collectByRank(collection, entry.getKey(), entry.getValue());
        }
        return collection;
    }

    private Map<ResultRank, Integer> init() {
        // 정렬 출력을 위해 TreeMap 으로 변경
        Map<ResultRank, Integer> collection = new TreeMap<>();
        for (ResultRank rank : ResultRank.values()) {
            collectByRank(collection, rank, EMPTY_COUNT);
        }
        return collection;
    }

    private void collectByRank(Map<ResultRank, Integer> collection, ResultRank rank, Integer count) {
        if (rank.isNone()) {
            return;
        }
        collection.put(rank, count);
    }

    public int calculatePrizeMoney(final Map<ResultRank, Integer> matchResults) {
        int prizeMoney = 0;
        for (Map.Entry<ResultRank, Integer> entry : matchResults.entrySet()) {
            prizeMoney += entry.getKey().prize() * entry.getValue();
        }
        return prizeMoney;
    }

    private float calculateRateOfReturn(int prizeMoney, int paid) {
        if (paid == EMPTY_PAID) {
            return NONE_RETURN_RATE;
        }
        return (float) prizeMoney / paid;
    }

    public int is(ResultRank rankMatch) {
        return matchCounts.getOrDefault(rankMatch, EMPTY_COUNT);
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public String detail() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<ResultRank, Integer> entry : matchCounts.entrySet()) {
            sb.append(String.format("%s - %d개\n", entry.getKey().detail(), entry.getValue()));
        }
        return sb.toString();
    }

    public float rateOfReturn() {
        return rateOfReturn;
    }
}
