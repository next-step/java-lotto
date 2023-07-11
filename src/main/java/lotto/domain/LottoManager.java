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

    public double calculateYield(WinningLotto winningLotto) {
        Map<LottoRank, Long> result = getResult(winningLotto);
        return result.keySet()
            .stream()
            .mapToDouble(key -> key.getPrize() * result.get(key))
            .sum() / (lottos.size() * 1000);
    }
}
