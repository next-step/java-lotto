package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void forEach(Consumer<? super Lotto> action) {
        lottos.forEach(action);
    }

    public static Lottos merge(Lottos one, Lottos another) {
        List<Lotto> merge = new ArrayList<>(one.lottos);
        merge.addAll(another.lottos);
        return new Lottos(merge);
    }

    public boolean containsAll(Lottos another) {
        return !another.anyMatch((lotto) -> !lottos.contains(lotto));
    }

    public boolean anyMatch(Predicate<? super Lotto> predicate) {
        return lottos.stream()
                .anyMatch(predicate);
    }
}
