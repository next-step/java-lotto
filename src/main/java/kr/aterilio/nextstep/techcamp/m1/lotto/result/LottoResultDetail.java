package kr.aterilio.nextstep.techcamp.m1.lotto.result;

import java.util.Map;
import java.util.TreeMap;

public class LottoResultDetail {

    private static final int EMPTY_COUNT = 0;
    private static final String FORMAT_DETAIL = "%s - %d개\n";

    private final Map<ResultRank, Integer> resultCount;

    public LottoResultDetail(Map<ResultRank, Integer> resultCount) {
        this.resultCount = collects(resultCount);
    }

    private Map<ResultRank, Integer> collects(Map<ResultRank, Integer> resultCount) {
        Map<ResultRank, Integer> collection = init();
        for (Map.Entry<ResultRank, Integer> entry : resultCount.entrySet()) {
            collection.put(entry.getKey(), entry.getValue());
        }
        return collection;
    }

    private Map<ResultRank, Integer> init() {
        // 정렬 출력을 위해 TreeMap 사용
        Map<ResultRank, Integer> collection = new TreeMap<>();
        for (ResultRank rank : ResultRank.values()) {
            collection.put(rank, EMPTY_COUNT);
        }
        collection.remove(ResultRank.NONE);
        return collection;
    }

    public int of(ResultRank rankMatch) {
        return resultCount.getOrDefault(rankMatch, EMPTY_COUNT);
    }

    public String detail() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<ResultRank, Integer> entry : resultCount.entrySet()) {
            sb.append(String.format(FORMAT_DETAIL, entry.getKey().detail(), entry.getValue()));
        }
        return sb.toString();
    }
}
