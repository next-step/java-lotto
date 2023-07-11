package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoManager {

    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoRank, Long> getResult(WinningLotto winningLotto) {
        return lottos.stream()
            .collect(Collectors.groupingBy(winningLotto::calculateRank, Collectors.counting()));
    }
}
