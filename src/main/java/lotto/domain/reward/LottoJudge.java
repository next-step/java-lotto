package lotto.domain.reward;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class LottoJudge {

    private final Lotto winningLotto;

    public LottoJudge(final Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<LottoRank, Long> judge(final List<Lotto> lottos) {
        return lottos.stream()
                .collect(Collectors.groupingBy(this::match, Collectors.counting()));
    }

    private LottoRank match(final Lotto lotto) {
        final int commonNumbersCount = lotto.countCommonNumbers(this.winningLotto);

        return LottoRank.from(commonNumbersCount);
    }
}
