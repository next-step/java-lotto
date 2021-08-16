package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<Award, Long> drawLottos(WinnerLotto winnerLotto) {
        Map<Award, Long> lottoResult = lottos.stream()
                .collect(Collectors
                        .groupingBy(lotto -> winnerLotto.drawLotto(lotto.getNumbers()),
                                Collectors.counting()));
        return Collections.unmodifiableMap(lottoResult);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
