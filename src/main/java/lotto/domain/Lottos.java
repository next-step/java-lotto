package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> lottos(){
        return Collections.unmodifiableList(lottos);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public static Lottos lottoBundle(final int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int idx = 0; idx < count; idx++) {
            lottos.add(LottoGenerator.lottoGenerator());
        }
        return new Lottos(lottos);
    }
}
