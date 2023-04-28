package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private final static int MATCH_COUNT_FOR_SECOND_RANK = 5;
    private final Map<Rank, Long> rankCounts;

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        rankCounts = calculateRankCounts(lottoNumbers, winningNumbers);
    }

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        rankCounts = calculateRankCounts(lottoNumbers, winningNumbers, bonusNumber);
    }

    private Map<Rank, Long> calculateRankCounts(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> LottoMatchInfo.countMatchingNumbers(lottoNumber, winningNumbers))
                .map(this::matchInfoToRank)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Map<Rank, Long> calculateRankCounts(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        return lottoNumbers.stream()
                .map(lottoNumber -> LottoMatchInfo.countMatchingNumbers(lottoNumber, winningNumbers, bonusNumber))
                .map(this::matchInfoToRank)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Rank matchInfoToRank(LottoMatchInfo matchInfo) {
        if (matchInfo.getMatchCount() == MATCH_COUNT_FOR_SECOND_RANK && matchInfo.isBonusMatch()) {
            return Rank.SECOND;
        }
        return Rank.valueOf(matchInfo.getMatchCount());
    }

    public long findRankCount(int matchCount) {
        return rankCounts.getOrDefault(Rank.valueOf(matchCount), 0L);
    }

}
