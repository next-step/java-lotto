package lotto.model.dto;

import lotto.model.LottoWinningResult;
import lotto.model.LottoWinningResults;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class LottoTotalResult {
    private final List<LottoWinningResultWithCount> winResult;
    private final BigDecimal profit;

    private LottoTotalResult(final List<LottoWinningResultWithCount> winResult, final BigDecimal profit) {
        this.winResult = winResult;
        this.profit = profit;
    }

    public static LottoTotalResult newInstance(final LottoWinningResults lottoWinningResults) {
        Map<LottoWinningResult, Long> result = makeOriginLottoResults(lottoWinningResults);

        List<LottoWinningResultWithCount> winResult = makeWinStatResultsWithoutBlank(result);

        return new LottoTotalResult(winResult, lottoWinningResults.profit());
    }

    private static List<LottoWinningResultWithCount> makeWinStatResultsWithoutBlank(final Map<LottoWinningResult, Long> result) {
        return Collections.unmodifiableList(result.keySet()
                .stream()
                .filter(lottoResult -> !lottoResult.isBlank())
                .map(lottoResult -> new LottoWinningResultWithCount(lottoResult, result.get(lottoResult)))
                .collect(Collectors.toList()));
    }

    private static Map<LottoWinningResult, Long> makeOriginLottoResults(final LottoWinningResults lottoWinningResults) {
        Map<LottoWinningResult, Long> result = new LinkedHashMap<>();
        Arrays.stream(LottoWinningResult.values())
                .forEach(lottoResult -> result.put(lottoResult, 0L));
        result.putAll(lottoWinningResults.getLottoResults());
        return result;
    }

    public List<LottoWinningResultWithCount> getWinResult() {
        return winResult;
    }

    public BigDecimal getProfit() {
        return profit;
    }
}
