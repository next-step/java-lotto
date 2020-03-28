package lotto.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResults {
    private Map<LottoResult, Long> lottoResults;

    private LottoResults(Map<LottoResult, Long> result) {
        this.lottoResults = Collections.unmodifiableMap(result);
    }

    public static LottoResults create(List<LottoResult> lottoResults) {
        Map<LottoResult, Long> result = lottoResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new LottoResults(result);
    }

    private static LottoResults getDefaultResult() {
        Map<LottoResult, Long> defaultResult = new LinkedHashMap<>();
        Arrays.stream(LottoResult.values())
                .forEach(lottoResult -> defaultResult.put(lottoResult, 0L));
        return new LottoResults(defaultResult);
    }
}
