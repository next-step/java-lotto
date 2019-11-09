package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public LottoRankGroup compareTo(WinningLotto winningLotto) {
        Map<LottoRank, Long> rankGroup = lottos
                .stream()
                .map(lotto -> lotto.matchTo(winningLotto))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoRankGroup(rankGroup);
    }

    public List<Lotto> getValue() {
        return new ArrayList<>(lottos);
    }

    public int size() {
        return lottos.size();
    }
}
