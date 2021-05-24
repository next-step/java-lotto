package lotto.domain;

import java.util.List;
import java.util.function.Consumer;

public class LottoList {
    private List<Lotto> lottos;

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void forEach(Consumer<? super Lotto> action){
        lottos.forEach(action);
    }
}
