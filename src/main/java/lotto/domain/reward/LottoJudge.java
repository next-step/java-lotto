package lotto.domain.reward;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class LottoJudge {

    public Map<LottoRank, Long> judge(final List<Lotto> lottos, final Lotto winningLotto) {
        return lottos.stream()
                .collect(Collectors.groupingBy(lotto -> match(lotto, winningLotto), Collectors.counting()));
    }

    private LottoRank match(final Lotto lotto, final Lotto winningLotto) {
        final int matchingCount = lotto.matchCount(winningLotto);

        return LottoRank.from(matchingCount);
    }
}
