package lotto.domain.reward;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class LottoJudge {

    public LottoResult judge(final List<Lotto> lottos, final Lotto winningLotto) {
        final Map<LottoRank, Long> result = lottos.stream()
                .collect(Collectors.groupingBy(lotto -> match(lotto, winningLotto), Collectors.counting()));

        return new LottoResult(result);
    }

    private LottoRank match(final Lotto lotto, final Lotto winningLotto) {
        final int matchingCount = lotto.matchCount(winningLotto);
        boolean isMatchedBonus = lotto.isMatchedBonus(winningLotto);

        return LottoRank.from(matchingCount, isMatchedBonus);
    }
}
