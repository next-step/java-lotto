package me.namuhuchutong.lotto;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoCount, Lotto> lottoResult;

    public LottoResult(Map<LottoCount, Lotto> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public long getWinnings(long minimumCount) {
        return lottoResult.keySet()
                          .stream()
                          .filter(filterMinimumCount(minimumCount))
                          .mapToLong(LottoWinnings::valueOfCount)
                          .sum();
    }

    public List<String> getLottoCountResult(long minimumCount) {
        return lottoResult.keySet()
                          .stream()
                          .filter(filterMinimumCount(minimumCount))
                          .map(buildMatchNumberAndCount())
                          .collect(Collectors.toList());
    }

    private Predicate<LottoCount> filterMinimumCount(long minimumCount) {
        return count -> count.getCount() >= minimumCount;
    }

    private Function<LottoCount, String> buildMatchNumberAndCount() {
        return lottoCount -> lottoCount.toString() + ": "
                + lottoResult.get(lottoCount).getSize() + "\n"
                + lottoResult.get(lottoCount);
    }

    @Override
    public String toString() {
        return lottoResult.toString();
    }
}
