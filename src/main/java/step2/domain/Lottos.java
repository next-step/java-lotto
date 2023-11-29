package step2.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
