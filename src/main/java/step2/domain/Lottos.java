package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<LottoNumberGenerator> lottoNumberGenerators) {
        this.lottos = lottoNumberGenerators.stream()
                .map(lottoNumberGenerator -> new Lotto(lottoNumberGenerator))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Integer, Long> getMatchResults(Lotto winnerLotto) {
        return lottos.stream()
                .map(lotto -> lotto.matchNumberCounts(winnerLotto))
                .filter(matchedNumbers -> matchedNumbers > 2)
                .collect(Collectors.groupingBy(matchedNumbers -> matchedNumbers, Collectors.counting()));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return lottos.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
