package lotto.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LottoBundle {

    private List<Lotto> lottos;

    private LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    static LottoBundle of(List<Lotto> lottos) {
        return new LottoBundle(lottos);
    }

    int getLottosCount() {
        return lottos.size();
    }

    public void forEach(Consumer<? super Lotto> action) {
        lottos.forEach(action);
    }

    public Stream<Lotto> stream(){
        return lottos.stream();
    }
}
