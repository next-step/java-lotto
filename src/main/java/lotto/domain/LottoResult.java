package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int NO_BONUS_NUMBER = 0;

    private final Map<Rank, Long> rankCounts;

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers) {
        rankCounts = lottoNumbers.stream()
                .map(lotto -> createRank(lotto, winningNumbers, NO_BONUS_NUMBER))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public LottoResult(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        rankCounts = lottoNumbers.stream()
                .map(lotto -> createRank(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private Rank createRank(LottoNumber lotto, List<Integer> winningNumbers, int bonusNumber) {
        LottoMatchInfo lottoMatchInfo = LottoMatchInfo.countMatchingNumbers(lotto, winningNumbers, bonusNumber);

        return Rank.valueOf(lottoMatchInfo.getMatchCount(), lottoMatchInfo.isBonusMatch());
    }

    public long findRankCount(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.valueOf(matchCount, bonusMatch);

        return rankCounts.getOrDefault(rank, 0L);
    }

}
