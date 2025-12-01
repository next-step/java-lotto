package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addLottos(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
