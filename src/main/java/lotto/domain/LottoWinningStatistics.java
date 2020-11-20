package lotto.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static lotto.domain.LottoRuleConfig.*;

public class LottoWinningStatistics {

    private LottoWinningStatistics() {}

    public static Map<LottoResult, AtomicInteger> getResults(List<LottoResult> lottoResults) {
        Map<LottoResult, AtomicInteger> map = initResultMap();
        for(LottoResult lottoResult : lottoResults) {
            if(lottoResult.getWinningCount() == IGNORE_LOTTO_RESULT_ZERO_RANK)
                continue;

            map.get(lottoResult).incrementAndGet();
        }
        return map;
    }

    private static Map<LottoResult, AtomicInteger> initResultMap() {
        Map<LottoResult, AtomicInteger> map = new LinkedHashMap<>();
        for(LottoResult lottoResult : reverseLottoResultValues()) {
            if(lottoResult.getWinningCount() == IGNORE_LOTTO_RESULT_ZERO_RANK)
                continue;

            map.put(lottoResult,new AtomicInteger());
        }
        return map;
    }

    private static List<LottoResult> reverseLottoResultValues() {
        return Arrays.stream(LottoResult.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
