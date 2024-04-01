package lotto.domain.reward;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class LottoJudge {

    public LottoResult judge(final List<Lotto> lottos, final WinningLotto winningLotto) {
        final Map<LottoRank, Long> result = lottos.stream()
                .collect(Collectors.groupingBy(winningLotto::match, Collectors.counting()));

        return new LottoResult(result);
    }
}
