package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoBundle of(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(Lotto.create());
        }

        return new LottoBundle(lottos);
    }

    public int count() {
        return lottos.size();
    }
}
