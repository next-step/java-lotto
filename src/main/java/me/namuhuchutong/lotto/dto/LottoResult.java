package me.namuhuchutong.lotto.dto;


import me.namuhuchutong.lotto.domain.Lotto;
import me.namuhuchutong.lotto.domain.LottoCount;
import me.namuhuchutong.lotto.domain.LottoWinnings;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {

    private final Map<LottoCount, Lotto> lottoResult;

    public LottoResult(Map<LottoCount, Lotto> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public long getWinnings(long minimumCount) {
        return getResultStreamAndFilterMinimumCount(minimumCount)
                          .mapToLong(LottoWinnings::valueOfCount)
                          .sum();
    }

    public List<String> getLottoCountResult(long minimumCount) {
        return getResultStreamAndFilterMinimumCount(minimumCount)
                          .map(buildMatchNumberAndCount())
                          .collect(Collectors.toList());
    }

    private Stream<LottoCount> getResultStreamAndFilterMinimumCount(long minimumCount) {
        return lottoResult.keySet()
                          .stream()
                          .filter(filterMinimumCount(minimumCount));
    }

    private Predicate<LottoCount> filterMinimumCount(long minimumCount) {
        return count -> count.getCount() >= minimumCount;
    }

    private Function<LottoCount, String> buildMatchNumberAndCount() {
        return lottoCount -> lottoCount.toString() + ": " + lottoResult.get(lottoCount) + "\n";
    }

    public int size() {
        return this.lottoResult.size();
    }

    @Override
    public String toString() {
        return lottoResult.toString();
    }
}
