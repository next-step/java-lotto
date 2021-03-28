package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public WinningStatistics winningStatistics(Lotto winningLotto) {
        return new WinningStatistics(this, winningLotto);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
