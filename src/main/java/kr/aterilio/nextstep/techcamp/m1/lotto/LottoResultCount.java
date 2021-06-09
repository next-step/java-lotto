package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.Map;
import java.util.TreeMap;

public class LottoResultCount {

    private static final int EMPTY_COUNT = 0;

    private final Map<ResultRank, Integer> resultCount;

    public LottoResultCount(Map<ResultRank, Integer> resultCount) {
        this.resultCount = collects(resultCount);
    }

    private Map<ResultRank, Integer> collects(Map<ResultRank, Integer> resultCount) {
        Map<ResultRank, Integer> collection = init();
        for (Map.Entry<ResultRank, Integer> entry : resultCount.entrySet()) {
            collectByRank(collection, entry.getKey(), entry.getValue());
        }
        return collection;
    }

    private Map<ResultRank, Integer> init() {
        // 정렬 출력을 위해 TreeMap 사용
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

    public int calculatePrizeMoney() {
        int prizeMoney = 0;
        for (Map.Entry<ResultRank, Integer> entry : resultCount.entrySet()) {
            prizeMoney += entry.getKey().prize() * entry.getValue();
        }
        return prizeMoney;
    }

    public int is(ResultRank rankMatch) {
        return resultCount.getOrDefault(rankMatch, EMPTY_COUNT);
    }

    public String detail() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<ResultRank, Integer> entry : resultCount.entrySet()) {
            sb.append(String.format("%s - %d개\n", entry.getKey().detail(), entry.getValue()));
        }
        return sb.toString();
    }
}
