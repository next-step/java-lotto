package lotto.domain;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class LottoWinningStatistics {

    private LottoWinningStatistics() {}

    public static LottoWinningResults getStatistics(List<LottoResult> lottoResults) {
        Map<LottoResult,LottoWinningResult> lottoWinningResults = initWinningResults();
        lottoResults.stream()
                .filter(e -> e != LottoResult.NONE)
                .forEach(e -> lottoWinningResults.get(e).incrementOfCount());
        return new LottoWinningResults(new LinkedList<>(lottoWinningResults.values()));
    }

    public static BigInteger getProfit(LottoWinningResults winningResults) {
        List<BigInteger> numbers = winningResults.getLottoWinningResults().stream()
                .filter(e -> e.getCount() > 0)
                .map(e -> getSumPrize(e.getLottoResult(),e.getCount()))
                .collect(Collectors.toList());
        return numbers.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    private static Map<LottoResult,LottoWinningResult> initWinningResults() {
        Map<LottoResult,LottoWinningResult> lottoWinningResults = new LinkedHashMap<>();
        reverseLottoResultValues().stream()
            .filter(e -> e != LottoResult.NONE)
            .forEach(e -> lottoWinningResults.put(e,new LottoWinningResult(e)));
        return lottoWinningResults;
    }

    private static BigInteger getSumPrize(LottoResult lottoResult, int count) {
        return BigInteger.valueOf(lottoResult.getPrize() * count);
    }

    private static List<LottoResult> reverseLottoResultValues() {
        return Arrays.stream(LottoResult.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
