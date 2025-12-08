package lotto;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public Lottos(Lotto... lottos) {
        this(List.of(lottos));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }
}
