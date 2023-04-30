package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private final static int NO_BONUS_NUMBER = 0;
    private final Map<Rank, Long> rankCounts;

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        rankCounts = calculateRankCounts(lottoNumbers, winningNumbers);
    }

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        rankCounts = calculateRankCounts(lottoNumbers, winningNumbers, bonusNumber);
    }

    public long findRankCount(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.valueOf(matchCount, bonusMatch);
        return rankCounts.getOrDefault(rank, 0L);
    }

    private Map<Rank, Long> calculateRankCounts(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> LottoMatchInfo.countMatchingNumbers(lottoNumber, winningNumbers, NO_BONUS_NUMBER))
                .map(matchInfo -> Rank.valueOf(matchInfo.getMatchCount(), matchInfo.isBonusMatch()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Map<Rank, Long> calculateRankCounts(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        return lottoNumbers.stream()
                .map(lottoNumber -> LottoMatchInfo.countMatchingNumbers(lottoNumber, winningNumbers, bonusNumber))
                .map(matchInfo -> Rank.valueOf(matchInfo.getMatchCount(), matchInfo.isBonusMatch()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
