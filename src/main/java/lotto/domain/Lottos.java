package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        if (lottos != null && !lottos.isEmpty()) {
            this.lottos.addAll(lottos);
        }
    }

    public boolean isEmpty() {
        return lottos.isEmpty();
    }

    public int size() {
        return lottos.size();
    }

    public void forEach(Consumer<Lotto> action) {
        lottos.forEach(action);
    }
}
