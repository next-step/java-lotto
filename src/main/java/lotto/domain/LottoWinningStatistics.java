package lotto.domain;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static lotto.domain.LottoRuleConfig.*;

public class LottoWinningStatistics {

    private LottoWinningStatistics() {}

    public static Map<LottoResult, AtomicInteger> getStatistics(List<LottoResult> lottoResults) {
        Map<LottoResult, AtomicInteger> map = initResultMap();
        lottoResults.stream()
                .filter(e -> e.getWinningCount() != IGNORE_LOTTO_RESULT_ZERO_RANK)
                .forEach(result -> map.get(result).incrementAndGet());
        return map;
    }

    public static BigInteger getProfit(Map<LottoResult, AtomicInteger> statistics) {
        List<BigInteger> numbers = statistics.entrySet().stream()
                .filter(e -> e.getValue().intValue() > 0)
                .map(k -> getSumPrize(k.getKey(),k.getValue()))
                .collect(Collectors.toList());
        return numbers.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    private static BigInteger getSumPrize(LottoResult lottoResult, AtomicInteger integer) {
        return BigInteger.valueOf(lottoResult.getPrize() * integer.intValue());
    }

    private static Map<LottoResult, AtomicInteger> initResultMap() {
        Map<LottoResult, AtomicInteger> map = new LinkedHashMap<>();
        reverseLottoResultValues().stream()
                .filter(e -> e.getWinningCount() != IGNORE_LOTTO_RESULT_ZERO_RANK)
                .forEach(result -> map.put(result,new AtomicInteger()));
        return map;
    }

    private static List<LottoResult> reverseLottoResultValues() {
        return Arrays.stream(LottoResult.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
