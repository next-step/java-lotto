package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<Rank> match(String winningNumbers) {
        List<Rank> ranks = new ArrayList<>();
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        for (Lotto lotto : lottos) {
            ranks.add(Rank.from(lotto.matchCount(winningLotto)));
        }
        return ranks;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
