package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<LottoResult> createResult(Numbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningNumbers))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
