package lotto.domain;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<Rank, Long> rankCounts = new HashMap<>();

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        setRankCounts(lottoNumbers, winningNumbers);
    }

    private void setRankCounts(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        rankCounts = lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.countMatchingNumbers(winningNumbers))
                .map(Rank::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public long findRankCount(int matchCount) {
        return rankCounts.getOrDefault(Rank.valueOf(matchCount), 0L);
    }

}
