package lotto.domain.reward;

import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lottos;

public class LottoJudge {

    public LottoResult judge(final Lottos lottos, final WinningLotto winningLotto) {
        final Map<LottoRank, Long> result = lottos.allLottos()
                .stream()
                .collect(Collectors.groupingBy(winningLotto::match, Collectors.counting()));

        return new LottoResult(result);
    }
}
