package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcher {

    private final LottoNumbers winningLottoNumbers;
    private List<Rank> rankResult;

    public LottoMatcher(final LottoNumbers winningLottoNumbers, final Lottos lottos) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.rankResult = matchWithWinningLottoNumbers(lottos);
    }

    private List<Rank> matchWithWinningLottoNumbers(final Lottos lottos) {
        List<Rank> result = new ArrayList<>();
        for (LottoNumbers lotto : lottos.value()) {
            int matchCount = lotto.countSameNumber(winningLottoNumbers);
            result.add(Rank.findRank(matchCount));
        }
        return result;
    }

    public List<LottoResult> classifyByRank() {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Rank rank : Rank.valuesExcludeNoRewards()) {
            int count = countByRank(rank);
            lottoResults.add(new LottoResult(count, rank));
        }
        return lottoResults;
    }

    private int countByRank(Rank rank) {
        return (int) rankResult.stream()
                .filter(rank::equals)
                .count();
    }
}
