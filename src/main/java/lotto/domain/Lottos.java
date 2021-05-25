package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public void forEach(Consumer<? super Lotto> action) {
        lottos.forEach(action);
    }
}
