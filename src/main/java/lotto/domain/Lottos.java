package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> createLottos(int count, NumberStrategy numberStrategy) {
        for (int i = 0; i < count; i++) {
            this.lottos.add(Lotto.createFromNumbers(numberStrategy.generateNumber()));
        }
        return this.lottos;
    }

    public List<Rank> match(Lotto winningLotto, LottoNumber bonusNumber) {
        return this.lottos.stream()
                .map(lotto -> Rank.of(lotto.matchCount(winningLotto), lotto.isContains(bonusNumber)))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
